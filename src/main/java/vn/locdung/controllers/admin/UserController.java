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
@WebServlet(urlPatterns = { "/admin/user","/admin/edit-user", "/admin/delete-user","/admin/add-user" })
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public UserServiceImpl userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.setCharacterEncoding("UTF-8");
	    resp.setCharacterEncoding("UTF-8");

	    String url = req.getRequestURI();

	    if (url.contains("/admin/user")) {
	    	List<UserModel> userList = userService.findAll();
	        // Set các thuộc tính cho view
	        req.setAttribute("userList", userList);
	        // Forward đến trang JSP
	        req.getRequestDispatcher("/views/admin/listuser.jsp").forward(req, resp);
	    }else if(url.contains("/admin/edit-user")) {
	    	// Lấy tham số userid từ query string
	        String idParam = req.getParameter("id");
	        if (idParam != null) {
	            try {
	                int userId = Integer.parseInt(idParam);
	                UserModel user = userService.findById(userId); // Giả sử bạn đã viết hàm findById trong UserService

	                if (user != null) {
	                    // Đưa thông tin người dùng vào request attribute
	                    req.setAttribute("user", user);
	                    req.getRequestDispatcher("/views/admin/edit-user.jsp").forward(req, resp);
	                } else {
	                    // Nếu không tìm thấy người dùng, có thể chuyển hướng về trang lỗi hoặc trang danh sách
	                    resp.sendRedirect(req.getContextPath() + "/admin/user");
	                }
	            } catch (NumberFormatException e) {
	                e.printStackTrace();
	                resp.sendRedirect(req.getContextPath() + "/admin/user"); // Trường hợp ID không hợp lệ
	            }
	        } else {
	            resp.sendRedirect(req.getContextPath() + "/admin/user"); // Trường hợp thiếu ID
	        }
	    }else if(url.contains("/admin/delete-user")) {
	    	try {
	            // Lấy ID người dùng từ request parameter
	            String userIdParam = req.getParameter("id");
	            if (userIdParam != null && !userIdParam.isEmpty()) {
	                int userId = Integer.parseInt(userIdParam);

	                // Gọi service để xóa người dùng
	                boolean isDeleted = userService.deleteUserById(userId);

	                if (isDeleted) {
	                    // Nếu xóa thành công, chuyển thông báo thành công
	                    req.getSession().setAttribute("alert", "Xóa người dùng thành công!");
	                } else {
	                    // Nếu xóa thất bại, chuyển thông báo lỗi
	                    req.getSession().setAttribute("alert", "Xóa người dùng thất bại!");
	                }
	            } else {
	                req.getSession().setAttribute("alert", "ID người dùng không hợp lệ!");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            req.getSession().setAttribute("alert", "Đã xảy ra lỗi khi xóa người dùng!");
	        }

	        // Chuyển hướng về trang danh sách người dùng
	        resp.sendRedirect(req.getContextPath() + "/admin/user");
	    }else if(url.contains("/admin/add-user")) {
	    	req.getRequestDispatcher("/views/admin/add-user.jsp").forward(req, resp);
	    }
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	    resp.setCharacterEncoding("UTF-8");
	    String url = req.getRequestURI();
	    if (url.contains("/admin/edit-user")) {
	    	 try {
	             int userId = Integer.parseInt(req.getParameter("userid"));
	             String username = req.getParameter("username");
	             String email = req.getParameter("email");
	             String phone = req.getParameter("phone");
	             String fullname = req.getParameter("fullname");

	             // Cập nhật thông tin người dùng
	             UserModel user = new UserModel();
	             user.setUserid(userId);
	             user.setUsername(username);
	             user.setEmail(email);
	             user.setPhone(phone);
	             user.setFullname(fullname);

	             boolean success = userService.updateUser(user);

	             if (success) {
	                 // Nếu cập nhật thành công, chuyển hướng về danh sách user
	                 resp.sendRedirect(req.getContextPath() + "/admin/user");
	             } else {
	                 // Nếu cập nhật thất bại, hiển thị thông báo lỗi
	                 req.setAttribute("error", "Cập nhật thông tin thất bại!");
	                 req.setAttribute("user", user);
	                 req.getRequestDispatcher("/views/admin/edit-user.jsp").forward(req, resp);
	             }
	         } catch (Exception e) {
	             e.printStackTrace();
	             req.setAttribute("error", "Đã xảy ra lỗi khi cập nhật thông tin!");
	             req.getRequestDispatcher("/views/admin/edit-user.jsp").forward(req, resp);
	         }
	        
	    }else if(url.contains("/admin/add-user")) {
	    	try {
	            // Lấy dữ liệu từ form
	            String username = req.getParameter("username");
	            String fullname = req.getParameter("fullname");
	            String email = req.getParameter("email");
	            String phone = req.getParameter("phone");
	            String password = req.getParameter("password");
	            int roleId = Integer.parseInt(req.getParameter("roleId")); // ID vai trò (quản trị hoặc người dùng)

	            // Tạo đối tượng UserModel
	            UserModel newUser = new UserModel();
	            newUser.setUsername(username);
	            newUser.setFullname(fullname);
	            newUser.setEmail(email);
	            newUser.setPhone(phone);
	            newUser.setPassword(password); // Cần mã hóa nếu cần bảo mật
	            newUser.setRoleid(roleId);

	            // Thêm người dùng thông qua UserService
	            boolean isAdded = userService.addUser(newUser);

	            if (isAdded) {
	                // Nếu thêm thành công, hiển thị thông báo
	                req.getSession().setAttribute("alert", "Thêm người dùng thành công!");
	            } else {
	                req.getSession().setAttribute("alert", "Thêm người dùng thất bại!");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            req.getSession().setAttribute("alert", "Đã xảy ra lỗi khi thêm người dùng!");
	        }

	        // Chuyển hướng về danh sách người dùng
	        resp.sendRedirect(req.getContextPath() + "/admin/user");
	    }
	}
}
