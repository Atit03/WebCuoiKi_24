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
		String sqll = "SELECT p.Productid, p.Productname, p.Price, pi.Imageurl\r\n" + "FROM products p\r\n"
				+ "JOIN productimages pi ON p.Productid = pi.Productid\r\n" + "WHERE pi.Isprimary = TRUE;";
		String sql = "SELECT p.Productid, p.Productname, p.Price, pi.Imageurl " + "FROM products p "
				+ "JOIN productimages pi ON p.Productid = pi.Productid " + "WHERE pi.Isprimary = TRUE ORDER BY p.Sold DESC " + "LIMIT 12;";

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
		String sql = "SELECT \r\n" + "            p.Productid, p.Productname, p.Price, p.Description, \r\n"
				+ "            pi.Imageurl, pi.Isprimary, \r\n"
				+ "            (SELECT COUNT(*) FROM Reviews r WHERE r.Productid = p.Productid) AS Ratingcount\r\n"
				+ "        FROM Products p\r\n" + "        JOIN ProductImages pi ON p.Productid = pi.Productid\r\n"
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
						product = new ProductModel(rs.getInt("Productid"), rs.getString("Productname"),
								rs.getString("Description"), rs.getBigDecimal("Price"), rs.getInt("Ratingcount"),
								rs.getString("Imageurl"), images); // Ảnh chính ban đầu
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

	@Override
	public List<ProductModel> getProductsByCategoryM(int categoryId, int page, int pageSize) {
		List<ProductModel> products = new ArrayList<>();

		// Kiểm tra đầu vào
		if (page < 1 || pageSize <= 0) {
			throw new IllegalArgumentException("Invalid page or pageSize value.");
		}

		String sql = "SELECT p.Productid, p.Productname, p.Price, pi.Imageurl " + "FROM products p "
				+ "JOIN productimages pi ON p.Productid = pi.Productid "
				+ "WHERE pi.Isprimary = TRUE AND p.Categoryid = ? AND p.Gender='Men'" + "LIMIT ? OFFSET ?";

		try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, categoryId);
			ps.setInt(2, pageSize);
			ps.setInt(3, (page - 1) * pageSize);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					ProductModel product = new ProductModel();
					product.setProductid(rs.getInt("Productid"));
					product.setProductname(rs.getString("Productname"));
					product.setPrice(rs.getBigDecimal("Price"));
					product.setImage(rs.getString("Imageurl"));

					// Thêm sản phẩm vào danh sách
					products.add(product);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Nên thay bằng log trong môi trường sản xuất
			throw new RuntimeException("Database query error: " + e.getMessage(), e);
		}

		return products;
	}

	@Override
	public int getTotalProductsByCategoryM(int categoryId) {
		String sql = "SELECT COUNT(*) AS total FROM products WHERE Categoryid = ? AND Gender='Men'";
		try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, categoryId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getInt("total");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Database query error: " + e.getMessage(), e);
		}
		return 0;
	}

	@Override
	public List<ProductModel> getProductsByCategoryW(int categoryId, int page, int pageSize) {
		List<ProductModel> products = new ArrayList<>();

		// Kiểm tra đầu vào
		if (page < 1 || pageSize <= 0) {
			throw new IllegalArgumentException("Invalid page or pageSize value.");
		}

		String sql = "SELECT p.Productid, p.Productname, p.Price, pi.Imageurl " + "FROM products p "
				+ "JOIN productimages pi ON p.Productid = pi.Productid "
				+ "WHERE pi.Isprimary = TRUE AND p.Categoryid = ? AND p.Gender='Women'" + "LIMIT ? OFFSET ?";

		try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, categoryId);
			ps.setInt(2, pageSize);
			ps.setInt(3, (page - 1) * pageSize);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					ProductModel product = new ProductModel();
					product.setProductid(rs.getInt("Productid"));
					product.setProductname(rs.getString("Productname"));
					product.setPrice(rs.getBigDecimal("Price"));
					product.setImage(rs.getString("Imageurl"));

					// Thêm sản phẩm vào danh sách
					products.add(product);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Nên thay bằng log trong môi trường sản xuất
			throw new RuntimeException("Database query error: " + e.getMessage(), e);
		}

		return products;
	}

	@Override
	public int getTotalProductsByCategoryW(int categoryId) {
		String sql = "SELECT COUNT(*) AS total FROM products WHERE Categoryid = ? AND Gender='Women'";
		try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, categoryId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getInt("total");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Database query error: " + e.getMessage(), e);
		}
		return 0;
	}

	@Override
	public List<ProductModel> findAllMen(int page, int pageSize) {
		List<ProductModel> products = new ArrayList<>();

		// Kiểm tra đầu vào
		if (page < 1 || pageSize <= 0) {
			throw new IllegalArgumentException("Invalid page or pageSize value.");
		}
		String sql = "SELECT p.Productid, p.Productname, p.Price, pi.Imageurl " + "FROM products p "
				+ "JOIN productimages pi ON p.Productid = pi.Productid " 
				+ "WHERE pi.Isprimary = TRUE AND p.Gender='Men'" + "LIMIT ? OFFSET ?";
		try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, pageSize);
			ps.setInt(2, (page - 1) * pageSize);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					ProductModel product = new ProductModel();
					product.setProductid(rs.getInt("Productid"));
					product.setProductname(rs.getString("Productname"));
					product.setPrice(rs.getBigDecimal("Price"));
					product.setImage(rs.getString("Imageurl"));

					// Thêm sản phẩm vào danh sách
					products.add(product);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Nên thay bằng log trong môi trường sản xuất
			throw new RuntimeException("Database query error: " + e.getMessage(), e);
		}

		return products;
	}

	@Override
	public List<ProductModel> findAllWomen(int page, int pageSize) {
		List<ProductModel> products = new ArrayList<>();

		// Kiểm tra đầu vào
		if (page < 1 || pageSize <= 0) {
			throw new IllegalArgumentException("Invalid page or pageSize value.");
		}
		String sql = "SELECT p.Productid, p.Productname, p.Price, pi.Imageurl " + "FROM products p "
				+ "JOIN productimages pi ON p.Productid = pi.Productid " 
				+ "WHERE pi.Isprimary = TRUE AND p.Gender='Women'" + "LIMIT ? OFFSET ?";
		try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, pageSize);
			ps.setInt(2, (page - 1) * pageSize);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					ProductModel product = new ProductModel();
					product.setProductid(rs.getInt("Productid"));
					product.setProductname(rs.getString("Productname"));
					product.setPrice(rs.getBigDecimal("Price"));
					product.setImage(rs.getString("Imageurl"));

					// Thêm sản phẩm vào danh sách
					products.add(product);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Nên thay bằng log trong môi trường sản xuất
			throw new RuntimeException("Database query error: " + e.getMessage(), e);
		}

		return products;
	}

	@Override
	public int getTotalProductsMen() {
		String sql = "SELECT COUNT(*) AS total FROM products WHERE Gender='Men'";
		try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getInt("total");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Database query error: " + e.getMessage(), e);
		}
		return 0;
	}

	@Override
	public int getTotalProductsWomen() {
		String sql = "SELECT COUNT(*) AS total FROM products WHERE Gender='Women'";
		try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getInt("total");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Database query error: " + e.getMessage(), e);
		}
		return 0;
	}

	@Override
	public List<ProductModel> getProductsNewM() {
		String sql = "SELECT p.Productid, p.Productname, p.Price, pi.Imageurl " + "FROM products p "
				+ "JOIN productimages pi ON p.Productid = pi.Productid " + "WHERE pi.Isprimary = TRUE AND Gender = 'Men' "+"ORDER BY Createdat DESC " + "LIMIT 12;";

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
	public List<ProductModel> getProductsNewW() {
		String sql = "SELECT p.Productid, p.Productname, p.Price, pi.Imageurl " + "FROM products p "
				+ "JOIN productimages pi ON p.Productid = pi.Productid " + "WHERE pi.Isprimary = TRUE AND Gender = 'Women' "+"ORDER BY Createdat DESC " + "LIMIT 12;";

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
	public List<ProductModel> getProductsBestSellerM() {
		String sql = "SELECT p.Productid, p.Productname, p.Price, pi.Imageurl " + "FROM products p "
				+ "JOIN productimages pi ON p.Productid = pi.Productid " + "WHERE pi.Isprimary = TRUE AND p.Gender = 'Men' "+"ORDER BY p.Sold DESC " + "LIMIT 12;";

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
	public List<ProductModel> getProductsBestSellerW() {
		String sql = "SELECT p.Productid, p.Productname, p.Price, pi.Imageurl " + "FROM products p "
				+ "JOIN productimages pi ON p.Productid = pi.Productid " + "WHERE pi.Isprimary = TRUE AND p.Gender = 'Women' "+"ORDER BY p.Sold DESC " + "LIMIT 12;";

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
	public List<ProductModel> search(String keyword) {
		String sql = "SELECT p.Productid, p.Productname, p.Price, pi.Imageurl " + "FROM products p "
				+ "JOIN productimages pi ON p.Productid = pi.Productid " + "WHERE pi.Isprimary = TRUE AND (p.Productname LIKE ? OR p.Description LIKE ?)";

		List<ProductModel> list = new ArrayList<>();

		try (Connection conn = new DBConnectMySQL().getDatabaseConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				) {
			ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
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


}
