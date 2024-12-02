package vn.locdung.services.impl;

import java.util.List;

import vn.locdung.daos.IProductDao;
import vn.locdung.daos.impl.ProductDaoImpl;
import vn.locdung.models.ProductModel;
import vn.locdung.services.IProductService;

public class ProductServiceImpl implements IProductService{
	IProductDao productDao = new ProductDaoImpl();
	@Override
	public List<ProductModel> findAll() {
		return productDao.findAll();
	}
	@Override
	public ProductModel findById(int id) {
		return productDao.findById(id);
	}
	@Override
	public List<ProductModel> getProductsByCategoryM(int categoryId, int page, int pageSize) {
		return productDao.getProductsByCategoryM(categoryId, page, pageSize);
	}
	@Override
	public int getTotalProductsByCategoryM(int categoryId) {
		return productDao.getTotalProductsByCategoryM(categoryId);
	}
	@Override
	public List<ProductModel> getProductsByCategoryW(int categoryId, int page, int pageSize) {
		return productDao.getProductsByCategoryW(categoryId, page, pageSize);
	}
	@Override
	public int getTotalProductsByCategoryW(int categoryId) {
		return productDao.getTotalProductsByCategoryW(categoryId);
	}

}
