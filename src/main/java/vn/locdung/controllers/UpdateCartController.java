package vn.locdung.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.locdung.daos.impl.CartDaoImpl;
@WebServlet("/updateCartItem")
public class UpdateCartController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	CartDaoImpl cartDao = new CartDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
            int cartitemid = Integer.parseInt(req.getParameter("cartitemid"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));

            cartDao.updateCartItemQuantity(cartitemid, quantity);
            resp.getWriter().write("Success");
        } catch (NumberFormatException e) {
            resp.getWriter().write("Invalid input");
        }
	}
}
