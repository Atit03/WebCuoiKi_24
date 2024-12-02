package vn.locdung.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.locdung.configs.DBConnectMySQL;
import vn.locdung.daos.ICategoryDao;
import vn.locdung.models.CategoryModel;
import vn.locdung.models.ProductModel;

public class CategoryDaoImpl implements ICategoryDao{

	@Override
	public List<CategoryModel> findAll() {
		String sql = "Select * from categories";
		List<CategoryModel> list = new ArrayList<>();
		try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				CategoryModel cate = new CategoryModel();
				cate.setCategoryid(rs.getInt("Categoryid"));
				cate.setCategoryname(rs.getString("Categoryname"));
				list.add(cate);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
		
	}

}
