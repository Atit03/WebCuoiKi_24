package vn.locdung.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.locdung.daos.impl.CartDaoImpl;

@WebServlet("/removeCartItem")
public class RemoveCartItemController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	CartDaoImpl cartDao = new CartDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
            // Lấy cartitemid từ request
            int cartitemid = Integer.parseInt(req.getParameter("cartitemid"));
            
            // Xóa sản phẩm khỏi giỏ hàng
            cartDao.removeCartItem(cartitemid);

            resp.getWriter().write("success"); // Gửi phản hồi thành công
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("error"); // Gửi phản hồi lỗi nếu có ngoại lệ
        }
	}
}
