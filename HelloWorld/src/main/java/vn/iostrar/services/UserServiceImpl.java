package vn.iostrar.services;

import vn.iostrar.dao.IUserDao;
import vn.iostrar.dao.impl.UserDaoImpl;
import vn.iostrar.models.UserModel;

public class UserServiceImpl implements IUserService {
	IUserDao userDao = new UserDaoImpl() ;
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName (username) ;
		if (user != null && password. equals (user.getPassword ())) {
			return user;
		}
		return null;
	}
	public static void main(String[] args)	{
		try {
			IUserService userServie = new UserServiceImpl();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public UserModel findByUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(username);
	}
	@Override
	public UserModel findByUsernameAndEmail(String username, String email) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean updatePassword(String username, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean checkExistEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean checkExistUsername(String username) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean register(String username, String email, String password, int i) {
		// TODO Auto-generated method stub
		return false;
	}
}
