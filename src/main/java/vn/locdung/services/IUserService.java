package vn.locdung.services;

import java.util.List;


import vn.locdung.models.UserModel;

public interface IUserService {
	UserModel login(String username,String password);
	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	void insert(UserModel user);
	
	UserModel findByEmail(String email);
}
