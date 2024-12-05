package vn.locdung.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.locdung.configs.DBConnectMySQL;
import vn.locdung.models.AddressModel;
import vn.locdung.models.UserModel;

public class AddressDaoImpl {
	public void insert(int userid, String fname, String address, String phone) {
		String sql = "INSERT INTO addresses (Userid, Fullname, Phone, Addressline) VALUES (?, ?, ?, ?)";

		try {
			Connection conn = new DBConnectMySQL().getDatabaseConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setString(2, fname);
			ps.setString(3, phone);
			ps.setString(4, address);
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<AddressModel> findByUser(int uid) {
		String sql = "SELECT Addressid, Fullname, Phone, Addressline FROM Addresses WHERE Userid = ?";
		List<AddressModel> list = new ArrayList<>();

		try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, uid);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					AddressModel ad = new AddressModel();
					ad.setAddressid(rs.getInt("Addressid"));
					ad.setFullname(rs.getString("Fullname"));
					ad.setPhone(rs.getString("Phone"));
					ad.setAddress(rs.getString("Addressline"));
					list.add(ad);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
