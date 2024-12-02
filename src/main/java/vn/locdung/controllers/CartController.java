package vn.locdung.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.locdung.daos.impl.CartDaoImpl;
import vn.locdung.models.CartItemModel;
import vn.locdung.models.UserModel;

@WebServlet("/add-to-cart")
public class CartController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	CartDaoImpl cartDao = new CartDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 // Đọc dữ liệu JSON từ body của yêu cầu
        BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
        StringBuilder json = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            json.append(line);
        }

        // Chuyển đổi JSON thành đối tượng ProductCartRequest
        Gson gson = new Gson();
        CartItemModel cartRequest = gson.fromJson(json.toString(), CartItemModel.class);

        int productId = cartRequest.getProductid();
        int quantity = cartRequest.getQuantity();
        BigDecimal price = cartRequest.getPrice(); // Lấy giá từ dữ liệu JSON
        String name = cartRequest.getProductname();  // Lấy tên từ dữ liệu JSON
     // Lấy session từ request
        HttpSession session = req.getSession(false); // false để không tạo mới session nếu chưa có

        // Lấy đối tượng 'account' từ session
        UserModel account = (UserModel) session.getAttribute("account");

        // Lấy userId từ đối tượng 'account'
        int userId = (account != null) ? account.getUserid() : -1; // Trả về -1 nếu không tìm thấy 'account'



        // Thêm sản phẩm vào giỏ hàng (hoặc tạo mới giỏ nếu chưa có)
        boolean success = cartDao.addToCart(userId, productId, quantity, name,price);
        // Cấu hình phản hồi
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        if (success) {
            out.print("{\"status\":\"success\"}");
        } else {
            out.print("{\"status\":\"error\"}");
        }
        out.flush();
    }
}
