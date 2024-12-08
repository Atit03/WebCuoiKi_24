package vn.locdung.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.locdung.models.ProductModel;
import vn.locdung.services.impl.ProductServiceImpl;
@WebServlet(urlPatterns = {"/productDetail"})
public class ProductController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public ProductServiceImpl productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();
		if (url.contains("/productDetail")) 
		{
			int productId = Integer.parseInt(req.getParameter("id"));
            ProductModel product = productService.findById(productId);
            System.out.println(product);
            if (product != null) {
                req.setAttribute("product", product);
                req.getRequestDispatcher("/views/detail.jsp").forward(req, resp);
            }
		}
	}

}
