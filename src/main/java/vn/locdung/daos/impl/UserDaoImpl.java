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
	                user.setUserid(rs.getInt("userid"));
	                user.setUsername(rs.getString("username"));
	                user.setPassword(rs.getString("password"));
	                user.setEmail(rs.getString("email"));
	                user.setFullname(rs.getString("fullname"));
	                user.setRoleid(rs.getInt("roleId"));
	                user.setStatus(rs.getInt("status"));
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return user;
	}

	@Override
	public List<UserModel> findUser(int page, int limit) {
		String sql = """
	            SELECT 
	                u.Userid,
	                u.Username,
	                u.Email,
	                u.Phone,
	                u.Roleid,
	                r.Rolename
	            FROM 
	                Users u
	            JOIN 
	                Roles r ON u.Roleid = r.Roleid
	            WHERE 
	                r.Rolename != 'Admin'
	            LIMIT ? OFFSET ?;
	            """;

	    List<UserModel> list = new ArrayList<>();

	    try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setInt(1, limit);              // Số bản ghi cần lấy
	        ps.setInt(2, (page - 1) * limit); // Tính OFFSET

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                UserModel user = new UserModel();
	                user.setUserid(rs.getInt("Userid"));
	                user.setUsername(rs.getString("Username"));
	                user.setEmail(rs.getString("Email"));
	                user.setPhone(rs.getString("Phone"));
	                user.setRoleid(rs.getInt("Roleid"));

	                list.add(user); // Thêm vào danh sách
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}

	@Override
	public int countUser() {
		String sql = "SELECT COUNT(*) FROM users\r\n"
				+ "WHERE \r\n"
				+ "    users.Roleid != 1;";
        int count = 0;
        try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
	}
//register
	@Override
	public void delete(int id) {
		String sql = "DELETE FROM users WHERE Userid = ?";
        try {
        	conn = new DBConnectMySQL().getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public void insertregister(UserModel user) {
		String sql = "Insert INTO users (email, username, fullname, password, status, roleId, code) Values (?,?,?,?,?,?,?)";
		try {
			conn = new DBConnectMySQL().getDatabaseConnection();

		    ps = conn.prepareStatement(sql);
		    ps.setString(1, user.getEmail());
		    ps.setString(2, user.getUsername());
		    ps.setString(3, user.getFullname());
		    ps.setString(4, user.getPassword());
		    ps.setInt(5, user.getStatus());
		    ps.setInt(6, user.getRoleid());
		    ps.setString(7, user.getCode());
		    ps.executeUpdate();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String sql = "Select * From Users where email = ?";
		try {
			conn = new DBConnectMySQL().getDatabaseConnection();
		    ps = conn.prepareStatement(sql);
		    ps.setString(1, email);
		    rs=ps.executeQuery();
		    if(rs.next()) {
		        duplicate =true;
		    }
		    ps.close();
		    conn.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String sql = "Select * From Users where username = ?";
		try {
			conn = new DBConnectMySQL().getDatabaseConnection();
		    ps = conn.prepareStatement(sql);
		    ps.setString(1, username);
		    rs=ps.executeQuery();
		    if(rs.next()) {
		        duplicate =true;
		    }
		    ps.close();
		    conn.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return duplicate;
	}

	@Override
	public void updatestatus(UserModel user) {
		String sql = "UPDATE Users SET status=?, code=? WHERE email=?";
		try {
			conn = new DBConnectMySQL().getDatabaseConnection();
		    ps = conn.prepareStatement(sql);

		    ps.setInt(1, user.getStatus());
		    ps.setString(2, user.getCode());
		    ps.setString(3, user.getEmail());
		    ps.executeUpdate();

		} catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}

		
	}
//register
}
