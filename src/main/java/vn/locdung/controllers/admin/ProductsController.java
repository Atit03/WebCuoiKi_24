package vn.locdung.controllers.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.locdung.models.ProductModel;
import vn.locdung.services.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/admin/product", "/admin/delete-product" })
public class ProductsController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public ProductServiceImpl productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURI();

		if (url.contains("/admin/product")) {
			List<ProductModel> productList = productService.findAllProducts();
			// Set các thuộc tính cho view
			req.setAttribute("productList", productList);
			// Forward đến trang JSP
			req.getRequestDispatcher("/views/admin/productlist.jsp").forward(req, resp);
		} else if (url.contains("/admin/product")) {
			String productIdParam = req.getParameter("id");

			try {
				int productId = Integer.parseInt(productIdParam); // Chuyển ID thành số nguyên

				// Gọi service để xóa sản phẩm
				boolean isDeleted = productService.deleteProductById(productId);

				// Kiểm tra kết quả và gửi thông báo
				if (isDeleted) {
					req.setAttribute("message", "Xóa sản phẩm thành công!");
				} else {
					req.setAttribute("alert", "Không tìm thấy sản phẩm để xóa.");
				}
			} catch (NumberFormatException e) {
				req.setAttribute("alert", "ID sản phẩm không hợp lệ!");
			} catch (Exception e) {
				req.setAttribute("alert", "Đã xảy ra lỗi khi xóa sản phẩm!");
				e.printStackTrace();
			}

			// Redirect về trang danh sách sản phẩm
			resp.sendRedirect(req.getContextPath() + "/admin/product");
		}
	}
}
