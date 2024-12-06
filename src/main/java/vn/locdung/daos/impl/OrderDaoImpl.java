package vn.locdung.daos.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vn.locdung.configs.DBConnectMySQL;
import vn.locdung.models.CartItemModel;
import vn.locdung.models.OrderModel;

public class OrderDaoImpl {
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
    public List<OrderModel> findById(int userid){
		List<OrderModel> orders = new ArrayList<>();
        String sql = "SELECT \r\n"
        		+ "    o.Orderid, \r\n"
        		+ "    a.Fullname, \r\n"
        		+ "    a.Addressline AS Address, \r\n"
        		+ "    a.Phone, \r\n"
        		+ "    o.Total, \r\n"
        		+ "    o.Paymentmethod\r\n"
        		+ "FROM \r\n"
        		+ "    Orders o\r\n"
        		+ "JOIN \r\n"
        		+ "    Addresses a ON o.Addressid = a.Addressid\r\n"
        		+ "WHERE \r\n"
        		+ "    o.Userid = ?;\r\n"
        		+ "";

        try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
        		PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userid);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                	OrderModel item = new OrderModel();
                    item.setOrderid(rs.getInt("Orderid"));
                    item.setFullname(rs.getString("Fullname"));
                    item.setAddress(rs.getString("Address"));
                    item.setPhone(rs.getString("Phone"));
                    item.setTotal(rs.getBigDecimal("Total"));
                    item.setPaymentmethod(rs.getString("Paymentmethod"));
                    orders.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
    public List<CartItemModel> getOrderDetailById(int orderid){
		List<CartItemModel> list = new ArrayList<>();
        String sql = "SELECT \r\n"
        		+ "    p.Productname, \r\n"
        		+ "    pi.Imageurl AS Image, \r\n"
        		+ "    p.Price, \r\n"
        		+ "    od.Quantity\r\n"
        		+ "FROM \r\n"
        		+ "    OrderDetails od\r\n"
        		+ "JOIN \r\n"
        		+ "    Products p ON od.Productid = p.Productid\r\n"
        		+ "LEFT JOIN \r\n"
        		+ "    ProductImages pi ON p.Productid = pi.Productid AND pi.Isprimary = TRUE\r\n"
        		+ "WHERE \r\n"
        		+ "    od.Orderid = ?;\r\n"
        		+ "";

        try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
        		PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, orderid);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                	CartItemModel item = new CartItemModel();
                    item.setProductname(rs.getString("Productname"));
                    item.setImage(rs.getString("Image"));
                    item.setPrice(rs.getBigDecimal("Price"));
                    item.setQuantity(rs.getInt("Quantity"));
                    list.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
