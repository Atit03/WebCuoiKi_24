package vn.locdung.daos;

import java.util.List;

import vn.locdung.models.UserModel;


public interface IUserDao {
	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	void insert(UserModel user);
	
	UserModel findByEmail(String email);
}
