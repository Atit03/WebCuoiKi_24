package vn.locdung.controllers;

import java.io.IOException;
import java.math.BigDecimal;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/oder")
public class OderController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String addressId = req.getParameter("addressid");
        String paymentMethod = req.getParameter("paymentmethod");
     // Lấy giá trị của tham số 'total' từ request
        String totalAmountStr = req.getParameter("total");
        
        int addid = Integer.parseInt(addressId);
        if (totalAmountStr != null && !totalAmountStr.trim().isEmpty()) {
            try {
                // Loại bỏ ký tự '$' nếu có và chuyển đổi thành BigDecimal
                totalAmountStr = totalAmountStr.replace("$", "").trim();
                BigDecimal totalAmount = new BigDecimal(totalAmountStr);
                System.out.println(totalAmount);
                // Sử dụng totalAmount ở đây (ví dụ, lưu vào cơ sở dữ liệu, xử lý logic đơn hàng)
            } catch (NumberFormatException e) {
                // Xử lý lỗi nếu giá trị không hợp lệ
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Giá trị tổng tiền không hợp lệ.");
            }
        } else {
            // Xử lý nếu tham số 'total' bị thiếu hoặc không hợp lệ
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Tham số 'total' không hợp lệ.");
        }
        System.out.println(addid);
        System.out.println(paymentMethod);
	}
}
