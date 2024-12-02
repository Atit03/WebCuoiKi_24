package vn.locdung.controllers;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.locdung.daos.ICategoryDao;
import vn.locdung.daos.impl.CategoryDaoImpl;
import vn.locdung.models.CategoryModel;
import vn.locdung.models.ProductModel;
import vn.locdung.services.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/woman", "/categoryW" })
public class Womancontroller extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ICategoryDao cateDao = new CategoryDaoImpl();
	public ProductServiceImpl productService = new ProductServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURI();
		if (url.contains("/woman")) {
			List<CategoryModel> lcate = cateDao.findAll();

			req.setAttribute("lcate", lcate);
			req.getRequestDispatcher("/views/woman.jsp").forward(req, resp);
		} else if (url.contains("/categoryW")) {
			String cid = req.getParameter("cid");
			String pageStr = req.getParameter("page");
			
			int categoryId = Integer.parseInt(cid);
			int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		    int pageSize = 6; // Số sản phẩm mỗi trang
			
			
			List<CategoryModel> lcate = cateDao.findAll();
			List<ProductModel> lproduct= productService.getProductsByCategoryW(categoryId, page, pageSize);
			int totalProducts = productService.getTotalProductsByCategoryW(categoryId);
			int totalPages = (int) Math.ceil((double) totalProducts / pageSize);
			
			req.setAttribute("lcate", lcate);
			req.setAttribute("lproduct", lproduct);
			//System.out.println(lproduct);
			req.setAttribute("currentPage", page);
            req.setAttribute("totalPages", totalPages);
			req.getRequestDispatcher("/views/woman.jsp").forward(req, resp);
		}
	}

}
