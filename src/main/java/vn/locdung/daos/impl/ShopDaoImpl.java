package vn.locdung.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import vn.locdung.configs.DBConnectMySQL;
import vn.locdung.daos.IShopDao;
import vn.locdung.models.ShopModel;

public class ShopDaoImpl implements IShopDao{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<ShopModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShopModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkShop(int userid) {
		String query = "SELECT 1 FROM shops WHERE Vendorid = ? LIMIT 1";
	    try (Connection con = new DBConnectMySQL().getDatabaseConnection();
	         PreparedStatement ps = con.prepareStatement(query)) {
	        ps.setInt(1, userid);
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
	            return 1; // Có shop
	        }
	    } catch (SQLException e) {
	        // Nên sử dụng một hệ thống logging thay vì printStackTrace()
	        System.err.println("Error checking shop existence for user " + userid);
	        e.printStackTrace();
	    }
	    return 0;
	}

	@Override
	public void insert(ShopModel shop) {
		// TODO Auto-generated method stub
		
	}

}
