package vn.locdung.services;

import java.util.List;


import vn.locdung.models.UserModel;

public interface IUserService {
	
	List<UserModel> findAll();
	List<UserModel> findUser(int page, int limit);
	int countUser();
	UserModel findById(int id);
	
	void insert(UserModel user);
	void delete(int id);
	UserModel findByEmail(String email);
	boolean updateUser(UserModel user);
	boolean deleteUserById(int userId);
	boolean addUser(UserModel user);
	
	//register
	boolean register(String email,String password,String username,String fullname,String code);
	void updatestatus(UserModel user);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	//register
	
	//login
	UserModel login(String username, String password);
}
