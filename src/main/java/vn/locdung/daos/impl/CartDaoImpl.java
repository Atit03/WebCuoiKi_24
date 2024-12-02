package vn.locdung.daos.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vn.locdung.configs.DBConnectMySQL;

public class CartDaoImpl {
	public boolean addToCart(int userId, int productId, int quantity, String productName, BigDecimal price) {
	    // Kết nối với cơ sở dữ liệu (sử dụng JDBC)
	    try (Connection conn = new DBConnectMySQL().getDatabaseConnection()) {
	        // Bắt đầu giao dịch
	        conn.setAutoCommit(false);  // Tắt chế độ tự động commit

	        // Kiểm tra hoặc tạo giỏ hàng
	        int cartId = getCartId(conn, userId);
	        if (cartId == -1) {
	            // Nếu không có giỏ hàng, tạo giỏ hàng mới
	            cartId = createNewCart(conn, userId);
	            if (cartId == -1) {
	                conn.rollback(); // Rollback nếu có lỗi trong quá trình tạo giỏ
	                return false;
	            }
	        }

	        // Thêm sản phẩm vào giỏ hàng
	        boolean success = addItemToCart(conn, cartId, productId, quantity, productName, price);
	        if (success) {
	            conn.commit();  // Commit giao dịch nếu mọi thứ thành công
	            return true;
	        } else {
	            conn.rollback(); // Rollback nếu có lỗi khi thêm sản phẩm
	            return false;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	private int getCartId(Connection conn, int userId) throws SQLException {
	    String checkCartQuery = "SELECT Cartid FROM Cart WHERE Userid = ?";
	    try (PreparedStatement ps = conn.prepareStatement(checkCartQuery)) {
	        ps.setInt(1, userId);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt("Cartid");
	            }
	        }
	    }
	    return -1;  // Không có giỏ hàng, trả về -1
	}

	private int createNewCart(Connection conn, int userId) throws SQLException {
	    String insertCartQuery = "INSERT INTO Cart (Userid) VALUES (?)";
	    try (PreparedStatement psInsert = conn.prepareStatement(insertCartQuery, Statement.RETURN_GENERATED_KEYS)) {
	        psInsert.setInt(1, userId);
	        int rowsAffected = psInsert.executeUpdate();
	        if (rowsAffected > 0) {
	            try (ResultSet generatedKeys = psInsert.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    return generatedKeys.getInt(1);  // Trả về Cartid vừa tạo
	                }
	            }
	        }
	    }
	    return -1;  // Không thể tạo giỏ hàng, trả về -1
	}

	private boolean addItemToCart(Connection conn, int cartId, int productId, int quantity, String productName, BigDecimal price) throws SQLException {
	    // Kiểm tra xem sản phẩm đã có trong giỏ hàng chưa
	    String checkItemQuery = "SELECT Quantity FROM cartitems WHERE Cartid = ? AND Productid = ?";
	    try (PreparedStatement psCheckItem = conn.prepareStatement(checkItemQuery)) {
	        psCheckItem.setInt(1, cartId);
	        psCheckItem.setInt(2, productId);
	        try (ResultSet rs = psCheckItem.executeQuery()) {
	            if (rs.next()) {
	                // Nếu sản phẩm đã có trong giỏ, cập nhật số lượng
	                int existingQuantity = rs.getInt("Quantity");
	                int newQuantity = existingQuantity + quantity;
	                String updateItemQuery = "UPDATE cartitems SET Quantity = ?, Updatedat = CURRENT_TIMESTAMP WHERE Cartid = ? AND Productid = ?";
	                try (PreparedStatement psUpdateItem = conn.prepareStatement(updateItemQuery)) {
	                    psUpdateItem.setInt(1, newQuantity);
	                    psUpdateItem.setInt(2, cartId);
	                    psUpdateItem.setInt(3, productId);
	                    int rowsAffected = psUpdateItem.executeUpdate();
	                    return rowsAffected > 0;
	                }
	            } else {
	                // Nếu sản phẩm chưa có trong giỏ, thêm mới vào CartItems
	                String insertCartItemQuery = "INSERT INTO cartitems (Cartid, Productid, Productname, Quantity, Price) VALUES (?, ?, ?, ?, ?)";
	                try (PreparedStatement psInsertItem = conn.prepareStatement(insertCartItemQuery)) {
	                    psInsertItem.setInt(1, cartId);
	                    psInsertItem.setInt(2, productId);
	                    psInsertItem.setString(3, productName);
	                    psInsertItem.setInt(4, quantity);
	                    psInsertItem.setBigDecimal(5, price);
	                    int rowsAffected = psInsertItem.executeUpdate();
	                    return rowsAffected > 0;
	                }
	            }
	        }
	    }
	}

}
