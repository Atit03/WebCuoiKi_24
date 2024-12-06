package vn.locdung.controllers;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.locdung.daos.impl.AddressDaoImpl;
import vn.locdung.daos.impl.CartDaoImpl;
import vn.locdung.models.AddressModel;
import vn.locdung.models.CartItemModel;

@WebServlet("/cartlist")
public class CartlistController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	CartDaoImpl cartDao = new CartDaoImpl();
	AddressDaoImpl addDao = new AddressDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String u = req.getParameter("uid");
		int userid = Integer.parseInt(u);
		List<CartItemModel> cartList = cartDao.findById(userid);
		List<AddressModel> addressList = addDao.findByUser(userid);
		req.setAttribute("cartList", cartList);
		req.setAttribute("addressList", addressList);
//		System.out.println(cartList);
		req.getRequestDispatcher("/views/cart.jsp").forward(req, resp);
	}
}
