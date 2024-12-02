package vn.locdung.controllers.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.locdung.models.UserModel;
import vn.locdung.services.impl.UserServiceImpl;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
@WebServlet(urlPatterns = { "/admin/user","/admin/user/update", "/admin/user/delete" })
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public UserServiceImpl userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURI();
		if (url.contains("/admin/user")) 
		{
			int page = 1; // Mặc định trang 1
            int limit = 3; // Mặc định 10 bản ghi mỗi trang

            String pageParam = req.getParameter("page");
            if (pageParam != null) {
                page = Integer.parseInt(pageParam);
            }

            String limitParam = req.getParameter("limit");
            if (limitParam != null) {
                limit = Integer.parseInt(limitParam);
            }

            // Lấy danh sách sách phân trang
            List<UserModel> list = userService.findUser(page, limit);
            int c = userService.countUser(); // Lấy tổng số sách trong cơ sở dữ liệu
            
            // Tính số trang
            int totalPages = (int) Math.ceil((double) c / limit);
            
            // Set các thuộc tính cho view
            req.setAttribute("list", list);
            req.setAttribute("totalPages", totalPages);
            req.setAttribute("currentPage", page);
			req.getRequestDispatcher("/views/admin/list-user.jsp").forward(req, resp);
			
			
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	    resp.setCharacterEncoding("UTF-8");

	    String url = req.getRequestURI();
	    
	    // Xử lý yêu cầu xóa tác giả
	    if (url.contains("/admin/user/delete")) {
	        int id = Integer.parseInt(req.getParameter("id"));
	        try {
	        	userService.delete(id);  // Gọi service để xóa tác giả
	            resp.sendRedirect(req.getContextPath() + "/admin/user");  // Redirect về danh sách tác giả
	        } catch (Exception e) {
	            e.printStackTrace();
	            req.setAttribute("error", "Lỗi khi xóa người dùng.");
	            req.getRequestDispatcher("/views/admin/list-user.jsp").forward(req, resp);
	        }
	    }
	}
}
