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

}
