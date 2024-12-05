package vn.locdung.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.locdung.daos.impl.AddressDaoImpl;
import vn.locdung.models.UserModel;

@WebServlet(urlPatterns = { "/addAddressForm","/addAddress"})
public class AddAddressController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	AddressDaoImpl addressDao = new AddressDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURI();
		if (url.contains("/addAddressForm")) 
		{
		
		req.getRequestDispatcher("/views/add-address.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	    resp.setCharacterEncoding("UTF-8");

	    String url = req.getRequestURI();
	    
	    if (url.contains("/addAddress")) {
	    	String fname = req.getParameter("fname");
	        String address = req.getParameter("address");
	        String phone = req.getParameter("phone");
	        
	        HttpSession session = req.getSession(false);
	        UserModel account = (UserModel) session.getAttribute("account");
	        int userId = (account != null) ? account.getUserid() : -1;
	        
	        addressDao.insert(userId, fname, address, phone);
	        resp.sendRedirect(req.getContextPath() + "/cartlist?uid=" + userId);
	    }
	}
	
}
