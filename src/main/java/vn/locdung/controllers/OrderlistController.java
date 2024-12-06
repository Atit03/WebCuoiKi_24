package vn.locdung.controllers;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.locdung.daos.impl.OrderDaoImpl;
import vn.locdung.models.CartItemModel;
import vn.locdung.models.OrderModel;
import vn.locdung.models.UserModel;

@WebServlet(urlPatterns = { "/orderlist","/orderdetail"})
public class OrderlistController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	OrderDaoImpl orderDao = new OrderDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURI();
		if (url.contains("/orderlist")) 
		{
			HttpSession session = req.getSession(false);
	        UserModel account = (UserModel) session.getAttribute("account");
	        int userId = (account != null) ? account.getUserid() : -1;
	        
	        List<OrderModel> orderList = orderDao.findById(userId);
	        req.setAttribute("orderList", orderList);
			req.getRequestDispatcher("/views/orderlist.jsp").forward(req, resp);
		} else if (url.contains("/orderdetail")) {
			int id = Integer.parseInt(req.getParameter("id"));
			List<CartItemModel> orderdetailList = orderDao.getOrderDetailById(id);
			req.setAttribute("orderdetailList", orderdetailList);
			req.getRequestDispatcher("/views/orderdetail.jsp").forward(req, resp);
		}
		
	}
}
