package vn.locdung.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.locdung.configs.DBConnectMySQL;
import vn.locdung.daos.IProductDao;
import vn.locdung.models.ProductModel;

public class ProductDaoImpl implements IProductDao {

	@Override
	public List<ProductModel> findAll() {
		String sql = "SELECT p.Productid, p.Productname, p.Price, pi.Imageurl\r\n" + "FROM products p\r\n"
				+ "JOIN productimages pi ON p.Productid = pi.Productid\r\n" + "WHERE pi.Isprimary = TRUE;";
		List<ProductModel> list = new ArrayList<>();

		try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				ProductModel product = new ProductModel();
				product.setProductid(rs.getInt("Productid"));
				product.setProductname(rs.getString("Productname"));
				product.setPrice(rs.getBigDecimal("Price"));
				product.setImage(rs.getString("Imageurl"));

				// Thêm người dùng vào danh sách
				list.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public ProductModel findById(int id) {
		String sql = "SELECT \r\n"
				+ "            p.Productid, p.Productname, p.Price, p.Description, \r\n"
				+ "            pi.Imageurl, pi.Isprimary, \r\n"
				+ "            (SELECT COUNT(*) FROM Reviews r WHERE r.Productid = p.Productid) AS Ratingcount\r\n"
				+ "        FROM Products p\r\n"
				+ "        JOIN ProductImages pi ON p.Productid = pi.Productid\r\n"
				+ "        WHERE p.Productid = ?";
		try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				ProductModel product = null;
				List<String> images = new ArrayList<>();
				String mainImage = null;

				while (rs.next()) {
					if (product == null) {
						// Tạo đối tượng ProductModel ban đầu
						product = new ProductModel(rs.getInt("Productid"), rs.getString("Productname"),rs.getString("Description"),
								rs.getBigDecimal("Price"),rs.getInt("Ratingcount"),
								rs.getString("Imageurl"),images); // Ảnh chính ban đầu
					}

					// Lưu ảnh chính nếu Isprimary = TRUE
					if (rs.getBoolean("Isprimary")) {
						mainImage = rs.getString("Imageurl");
						images.add(0, mainImage);
					} else {
						// Lưu các ảnh phụ vào danh sách
						images.add(rs.getString("Imageurl"));
					}
				}

				// Cập nhật ảnh chính và ảnh phụ vào đối tượng ProductModel
				if (product != null) {
					product.setImage(mainImage);
					product.setImages(images);
				}

				return product;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null; // hoặc bạn có thể ném ngoại lệ tùy theo yêu cầu
		}

	}

}
