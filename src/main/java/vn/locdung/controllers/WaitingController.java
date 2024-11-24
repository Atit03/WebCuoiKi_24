package vn.locdung.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.locdung.models.UserModel;
import vn.locdung.services.IShopService;
import vn.locdung.services.impl.ShopServiceImpl;

@WebServlet(urlPatterns = { "/waiting" })
public class WaitingController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
		if(session != null && session.getAttribute("account") != null) {
		UserModel u=(UserModel) session.getAttribute("account");
		if(u.getRoleid()==1) {
		resp.sendRedirect(req.getContextPath()+"/admin/home");
		}else if(u.getRoleid()==2) {
			IShopService shopService = new ShopServiceImpl();
			int checkShop = shopService.checkShop(u.getUserid());
			session.setAttribute("checkShop", checkShop);
			resp.sendRedirect(req.getContextPath()+"/vendor/home");
		}else if(u.getRoleid()==3) {
			resp.sendRedirect(req.getContextPath()+"/user/home");
		}else {
			resp.sendRedirect(req.getContextPath()+"/login");
		}
		}}
}
