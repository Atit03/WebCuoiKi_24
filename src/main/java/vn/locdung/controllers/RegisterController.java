package vn.locdung.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import vn.locdung.models.UserModel;
import vn.locdung.services.IUserService;
import vn.locdung.services.impl.UserServiceImpl;
import vn.locdung.utils.Email;

@WebServlet(urlPatterns = { "/register","/VerifyCode" })
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IUserService userService  = new UserServiceImpl();
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String url = req.getRequestURI();
		 if(url.contains("register")) {
			 req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
		 }else if(url.contains("VerifyCode")) {
			 req.getRequestDispatcher("/views/verify.jsp").forward(req, resp);
		 }
	    }
	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	String url = req.getRequestURI();
	    	if(url.contains("register")) {
				postRegister(req,resp);
			}else if(url.contains("VerifyCode")) {
				postVerifyCode(req,resp);
			}
	    }
	    private void postVerifyCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html;charset=UTF-8");
			try (PrintWriter out = resp.getWriter()) {
			    //truy cập session
			    HttpSession session = req.getSession();
			    UserModel user = (UserModel) session.getAttribute("account");

			    String code = req.getParameter("authcode");

			    if (code.equals(user.getCode())) {
			        user.setEmail(user.getEmail());
			        user.setStatus(1);
			        userService.updatestatus(user);

			        out.println("<div class=\"container\"><br/>\r\n" +
			                     "      <br/>\r\n" +
			                     "      <br/>Kích hoạt tài khoản thành công!<br/>\r\n" +
			                     "      <br/>\r\n"+
			                     "      <br/></div>");
			    } else {
			    	out.println("<div class=\"container\"><br/>\r\n" +
		                     "      <br/>\r\n" +
		                     "      <br/>Sai mã kích hoạt, vui lòng kiểm tra lại!<br/>\r\n" +
		                     "      <br/>\r\n"+
		                     "      <br/></div>");
			    } 
			}
			
		}
	    private void postRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			try {
				req.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//lấy tham số từ form
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String fullname = req.getParameter("fullname");

			String alertMsg = "";
			if (userService.checkExistEmail(email)) {
			    alertMsg = "Email đã tồn tại!";
			    req.setAttribute("error", alertMsg);
			    req.setAttribute("email", email);
			    try {
					req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (userService.checkExistUsername (username)) {
			    alertMsg = "Tài khoản đã tồn tại!";
			    req.setAttribute("error", alertMsg);
			    try {
					req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				Email sm  = new Email();
				String code = sm.getRandom();
				UserModel user = new UserModel(username,email,fullname, code);
				boolean test = sm.sendEmail(user);
				if (test) {
				    HttpSession session = req.getSession();
				    session.setAttribute("account", user);

				    boolean isSuccess = userService.register(email, password, username, fullname, code);

				    if (isSuccess) {
				        try {
							resp.sendRedirect(req.getContextPath() + "/VerifyCode");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    } else {
				        alertMsg = "Lỗi hệ thống!";
				        req.setAttribute("error", alertMsg);
				        try {
							req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
						} catch (ServletException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    }
				} else {
				    PrintWriter out = null;
					try {
						out = resp.getWriter();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    out.println("Lỗi khi gửi mail!!!!!!!!");
				}
			}
			
		}

}
