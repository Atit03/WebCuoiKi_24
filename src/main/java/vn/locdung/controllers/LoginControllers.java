package vn.locdung.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.locdung.models.UserModel;
import vn.locdung.services.IUserService;
import vn.locdung.services.impl.UserServiceImpl;
import vn.locdung.utils.Constant;

@WebServlet(urlPatterns = { "/login" })
public class LoginControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUserService service = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");
		boolean isRememberMe = false;
		if ("on".equals(remember)) {
			isRememberMe = true;
		}

		String alertMsg = "";

		// Kiểm tra trường email
		if (email.isEmpty()) {
			alertMsg = "Email không được rỗng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}

		// Kiểm tra trường password
		if (password.isEmpty()) {
			alertMsg = "Mật khẩu không được rỗng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}

		UserModel user = service.login(email, password);
		if (user != null) {
			if (user.getStatus() == 0) {
				alertMsg = "Tài khoản chưa được kích hoạt";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
				return;
			}

			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			if (isRememberMe) {
				saveRemeberMe(resp, email);
			}
			resp.sendRedirect(req.getContextPath() + "/waiting");

		} else {
			alertMsg = "Email hoặc mật khẩu không đúng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		}
	}

	private void saveRemeberMe(HttpServletResponse response, String username) {
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60);
		response.addCookie(cookie);
	}

}
