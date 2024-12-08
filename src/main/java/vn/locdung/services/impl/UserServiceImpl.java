package vn.locdung.services.impl;

import java.util.List;

import vn.locdung.daos.IUserDao;
import vn.locdung.daos.impl.UserDaoImpl;
import vn.locdung.models.UserModel;
import vn.locdung.services.IUserService;

public class UserServiceImpl implements IUserService{
	IUserDao userDao = new UserDaoImpl();
	@Override
	public List<UserModel> findAll() {
		return userDao.findAll();
	}
	
	public boolean updateUser(UserModel user) {
		return userDao.updateUser(user);
	}

	@Override
	public UserModel findById(int id) {
		return userDao.findById(id);
	}

	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserModel findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public UserModel login(String email, String password) {
		UserModel user = this.findByEmail(email);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public List<UserModel> findUser(int page, int limit) {
		return userDao.findUser(page,limit);
	}

	@Override
	public int countUser() {
		return userDao.countUser();
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}
//register
	@Override
	public boolean register(String email, String password, String username, String fullname, String code) {
		if (userDao.checkExistEmail(email)) {
		    return false;
		}
		if (userDao.checkExistUsername(username)) {
		    return false;
		}
		userDao.insertregister(new UserModel(username, email, fullname, password, 0, 2, code));
		return true;
	}

	@Override
	public void updatestatus(UserModel user) {
		userDao.updatestatus(user);
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}
//register

	@Override
	public boolean deleteUserById(int userId) {
		return userDao.deleteUserById(userId);
	}

	public boolean addUser(UserModel user) {
		
		return userDao.addUser(user);
	}
}
