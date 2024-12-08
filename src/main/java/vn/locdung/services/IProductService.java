package vn.locdung.services;

import java.util.List;

import vn.locdung.models.ProductModel;

public interface IProductService {
	List<ProductModel> findAll();
	ProductModel findById(int id);
	
	List<ProductModel> findAllMen(int page, int pageSize);
	int getTotalProductsMen();
	
	List<ProductModel> findAllWomen(int page, int pageSize);
	int getTotalProductsWomen();
	
	List<ProductModel> getProductsByCategoryM(int categoryId, int page, int pageSize);
	int getTotalProductsByCategoryM(int categoryId);
	
	List<ProductModel> getProductsByCategoryW(int categoryId, int page, int pageSize);
	int getTotalProductsByCategoryW(int categoryId);
	
	List<ProductModel> getProductsNewM();
	List<ProductModel> getProductsNewW();
	
	List<ProductModel> getProductsBestSellerM();
	List<ProductModel> getProductsBestSellerW();
	
	List<ProductModel> findAllProducts();
	boolean deleteProductById(int productId);
}
