package vn.locdung.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectMySQL {
	private final String USERNAME = "root";
	private final String PASSWORD = "170604";// thay đổi pass
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/uteshop";// thay đổi tên database

	public Connection getDatabaseConnection() throws SQLException{
		try {
	    	Class.forName(DRIVER);
			return DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (ClassNotFoundException e) {
        throw new SQLException("JDBC Driver không tìm thấy.", e);
		} catch (SQLException e) {
        throw new SQLException("Không thể kết nối đến cơ sở dữ liệu.", e);
		}
	}
	public static void main(String[] args) {
	    DBConnectMySQL dbConnect = new DBConnectMySQL();
	    try (Connection connection = dbConnect.getDatabaseConnection()) {
	        if (connection != null) {
	            System.out.println("Kết nối thành công!");
	        } else {
	            System.out.println("Kết nối thất bại!");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
