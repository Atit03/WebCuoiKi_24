package vn.locdung.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(urlPatterns = { "/logout" })
public class LogoutController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Hủy phiên làm việc (session)
        HttpSession session = req.getSession(false); // không tạo session mới nếu không có
        if (session != null) {
            session.invalidate(); // hủy session
        }

        // Chuyển hướng về trang đăng nhập hoặc trang khác
        resp.sendRedirect(req.getContextPath() + "/home");
	}
}
