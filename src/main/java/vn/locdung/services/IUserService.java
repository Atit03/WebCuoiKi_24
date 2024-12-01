package vn.locdung.services;

import java.util.List;


import vn.locdung.models.UserModel;

public interface IUserService {
	UserModel login(String username,String password);
	List<UserModel> findAll();
	List<UserModel> findUser(int page, int limit);
	int countUser();
	UserModel findById(int id);
	
	void insert(UserModel user);
	void delete(int id);
	UserModel findByEmail(String email);
}
