package vn.locdung.controllers.user;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.locdung.models.ProductModel;
import vn.locdung.services.impl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/user/home"})
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public ProductServiceImpl productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();
		if (url.contains("user/home")) 
		{
        List<ProductModel> productList = productService.findAll();
        req.setAttribute("productList", productList);
		req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
		}
	}

}
