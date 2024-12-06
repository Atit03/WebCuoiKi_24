package vn.locdung.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.locdung.daos.impl.CartDaoImpl;
import vn.locdung.daos.impl.OrderDaoImpl;
import vn.locdung.models.CartItemModel;
import vn.locdung.models.UserModel;
@WebServlet("/oder")
public class OderController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	CartDaoImpl cartDao = new CartDaoImpl();
	OrderDaoImpl oderDao =  new OrderDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String addressId = req.getParameter("addressid");
        String paymentMethod = req.getParameter("paymentmethod");
     // Lấy giá trị của tham số 'total' từ request
        String totalAmountStr = req.getParameter("total");
        
        HttpSession session = req.getSession(false);
        UserModel account = (UserModel) session.getAttribute("account");
        int userId = (account != null) ? account.getUserid() : -1;
        
        int addid = Integer.parseInt(addressId);
        
        totalAmountStr = totalAmountStr.replace("$", "").trim();
        BigDecimal totalAmount = new BigDecimal(totalAmountStr);
//        if (totalAmountStr != null && !totalAmountStr.trim().isEmpty()) {
//            try {
//                totalAmountStr = totalAmountStr.replace("$", "").trim();
//                BigDecimal totalAmount = new BigDecimal(totalAmountStr);
//                System.out.println(totalAmount);
//            } catch (NumberFormatException e) {
//                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Giá trị tổng tiền không hợp lệ.");
//            }
//        } else {
//            // Xử lý nếu tham số 'total' bị thiếu hoặc không hợp lệ
//            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Tham số 'total' không hợp lệ.");
//        }
//        System.out.println(addid);
//        System.out.println(paymentMethod);
        try {
            // Bắt đầu xử lý đơn hàng
            int orderId = oderDao.insertOrder(userId,addid, paymentMethod, totalAmount, "New");

            // Lấy danh sách các mục trong giỏ hàng
            List<CartItemModel> cartItems = cartDao.findById(userId);

            // Thêm chi tiết đơn hàng
            oderDao.insertOrderDetails(orderId, cartItems);

            // Xóa giỏ hàng sau khi thêm vào đơn hàng
            cartDao.clearCart(userId);

            // Chuyển hướng về trang xác nhận
            req.getRequestDispatcher("/views/order-complete.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Có lỗi xảy ra khi xử lý đơn hàng.");
        }
        
	}
}
