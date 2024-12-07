package vn.locdung.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.locdung.models.UserModel;
import vn.locdung.services.IUserService;
import vn.locdung.services.impl.UserServiceImpl;
import vn.locdung.utils.Email;

import java.io.IOException;

@WebServlet(urlPatterns = { "/forgot-password" })
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/forgot-password.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String email = req.getParameter("email");
		UserModel user = userService.findByEmail(email);
		if (user != null) {
			if (user.getEmail().equals(email)) {
				Email sm = new Email();

				boolean test = sm.EmailSend(user);
				if (test) {
					req.setAttribute("message", "Vui lòng kiểm tra email của bạn!");
				} else {
					req.setAttribute("error", "Lỗi gửi mail!");
				}
			}
		} else {
			req.setAttribute("error", "Email chưa được đăng ký!");
			req.getRequestDispatcher("views/forgot-password.jsp").forward(req, resp);
			return;
		}
		req.getRequestDispatcher("views/forgot-password.jsp").forward(req, resp);
	}

}
