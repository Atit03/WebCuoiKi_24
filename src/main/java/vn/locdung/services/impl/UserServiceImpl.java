package vn.locdung.services.impl;

import java.util.List;

import vn.locdung.daos.IUserDao;
import vn.locdung.daos.impl.UserDaoImpl;
import vn.locdung.models.UserModel;
import vn.locdung.services.IUserService;

public class UserServiceImpl implements IUserService{
	IUserDao useDao = new UserDaoImpl();
	@Override
	public List<UserModel> findAll() {
		return useDao.findAll();
	}

	@Override
	public UserModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserModel findByEmail(String email) {
		return useDao.findByEmail(email);
	}

	@Override
	public UserModel login(String email, String password) {
		UserModel user = this.findByEmail(email);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

}
