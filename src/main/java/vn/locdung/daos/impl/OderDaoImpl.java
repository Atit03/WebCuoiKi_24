package vn.locdung.daos.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import vn.locdung.configs.DBConnectMySQL;
import vn.locdung.models.CartItemModel;

public class OderDaoImpl {
	// Thêm một đơn hàng
    public int insertOrder(int uid ,int addressId, String paymentMethod, BigDecimal total, String status) throws SQLException {
        if (!isValidStatus(status)) {
            throw new IllegalArgumentException("Trạng thái không hợp lệ: " + status);
        }
        String sql = "INSERT INTO Orders (Userid,Addressid, Total, Paymentmethod,Status) VALUES (?, ?, ?, ?,?)";
        try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
        		PreparedStatement statement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, uid);
            statement.setInt(2, addressId);
            statement.setBigDecimal(3, total);
            statement.setString(4, paymentMethod);
            statement.setString(5, status);
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        }
        throw new SQLException("Failed to insert order, no ID obtained.");
    }
    private boolean isValidStatus(String status) {
        List<String> validStatuses = Arrays.asList("New", "Confirmed", "Shipping", "Delivered", "Cancelled", "Returned");
        return validStatuses.contains(status);
    }
    // Thêm chi tiết đơn hàng
    public void insertOrderDetails(int orderId, List<CartItemModel> cartItems) throws SQLException {
        String sql = "INSERT INTO OrderDetails (Orderid, Productid, Quantity) VALUES (?, ?, ?)";
        try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
        		PreparedStatement statement = conn.prepareStatement(sql)) {
            for (CartItemModel item : cartItems) {
                statement.setInt(1, orderId);
                statement.setInt(2, item.getProductid());
                statement.setInt(3, item.getQuantity());
                statement.addBatch();
            }
            statement.executeBatch();
        }
    }
}
