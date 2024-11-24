package vn.locdung.services;

import java.util.List;

import vn.locdung.models.ProductModel;

public interface IProductService {
	List<ProductModel> findAll();
	ProductModel findById(int id);
}
