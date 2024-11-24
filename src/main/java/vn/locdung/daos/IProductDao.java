package vn.locdung.daos;

import java.util.List;

import vn.locdung.models.ProductModel;

public interface IProductDao {
	List<ProductModel> findAll();
	ProductModel findById(int id);
}
