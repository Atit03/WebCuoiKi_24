package vn.locdung.daos;

import java.util.List;

import vn.locdung.models.CategoryModel;

public interface ICategoryDao {
	List<CategoryModel> findAll();
}
