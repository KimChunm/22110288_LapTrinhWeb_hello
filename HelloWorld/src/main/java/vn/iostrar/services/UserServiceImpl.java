package vn.iostrar.services;

import vn.iostrar.models.UserModel;

public class UserServiceImpl implements IUserService {
	IUserDao userDao = new UserDaoImp1() ;
	@Override
	public UserModel findByUserName (String username) {
		return userDao.findByUsername(username);
	}
	@Override
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
}
