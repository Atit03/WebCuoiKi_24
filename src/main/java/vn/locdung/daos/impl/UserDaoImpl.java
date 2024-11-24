package vn.locdung.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.locdung.configs.DBConnectMySQL;
import vn.locdung.daos.IUserDao;
import vn.locdung.models.UserModel;

public class UserDaoImpl implements IUserDao{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll(){
		 String sql = "SELECT * FROM users";
	        List<UserModel> list = new ArrayList<>();

	        try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
	             PreparedStatement ps = conn.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {

	            while (rs.next()) {
	                UserModel user = new UserModel();
	                user.setUserid(rs.getInt("Userid"));
	                user.setUsername(rs.getString("Username"));
	                user.setPassword(rs.getString("Password"));
	                user.setEmail(rs.getString("Email"));
	                user.setPhone(rs.getString("Phone"));
	                user.setRoleid(rs.getInt("Roleid"));
	                user.setIsactive(rs.getBoolean("Isactive"));

	                // Thêm người dùng vào danh sách
	                list.add(user);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return list;
	}

	@Override
	public UserModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserModel findByEmail(String email) {
		String sql = "SELECT * FROM users WHERE Email = ?";
	    UserModel user = null;

	    try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setString(1, email); // Gán tham số username vào câu lệnh SQL
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                user = new UserModel();
	                user.setUserid(rs.getInt("Userid"));
	                user.setUsername(rs.getString("Username"));
	                user.setPassword(rs.getString("Password"));
	                user.setEmail(rs.getString("Email"));
	                user.setPhone(rs.getString("Phone"));
	                user.setRoleid(rs.getInt("Roleid"));
	                user.setIsactive(rs.getBoolean("Isactive"));
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return user;
	}

}
