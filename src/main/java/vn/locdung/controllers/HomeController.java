package vn.locdung.controllers;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.locdung.daos.impl.ProductDaoImpl;
import vn.locdung.models.ProductModel;
import vn.locdung.services.impl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/home", "/search"})
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public ProductServiceImpl productService = new ProductServiceImpl();
	public ProductDaoImpl productDao = new ProductDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();
		if (url.contains("/home")) 
		{
        List<ProductModel> productList = productService.findAll();
        //System.out.println(productList);
        req.setAttribute("productList", productList);
		req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();
		if (url.contains("/search")) 
		{
			String keyw = req.getParameter("keyword");
			
			List<ProductModel> list = productDao.search(keyw);
			req.setAttribute("productList", list);
			req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
			
		}
	}
}