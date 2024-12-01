package vn.locdung.controllers;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.locdung.dao.DAO;
import vn.locdung.models.Product;

/**
 * Servlet implementation class HomeControl
 */
@WebServlet("/HomeControl")
public class HomeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HomeControl() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, 
	IOException {
		//get data
		DAO dao = new DAO();
        List<Product> list = dao.getAllProduct();
        //set data
        request.setAttribute("listP", list);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
	}
}
