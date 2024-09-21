package vn.iostrar.services.impl;

import vn.iostrar.dao.IUserDao;
import vn.iostrar.dao.impl.UserDaoImpl;
import vn.iostrar.models.UserModel;
import vn.iostrar.services.IUserService;

public class UserService implements IUserService {
	IUserDao userDao = new UserDaoImpl() ;
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName (username) ;
		if (user != null && password. equals (user.getPassword ())) {
			return user;
		}
		return null;
	}
	
	@Override
	public UserModel findByUserName(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(username);
	}
	 public UserModel findByUsernameAndEmail(String username, String email) {
	        return userDao.findByUsernameAndEmail(username, email);
	    }

	    @Override
	    public boolean updatePassword(String username, String newPassword) {
	        return userDao.updatePassword(username, newPassword);
	    }
	    @Override
	    public boolean register(String username, String email,String
	            password,int  roleid) {
	        if (userDao.checkExistUsername(username)) {
	            return false;
	        }
	        long millis=System.currentTimeMillis();
	        java.sql.Date date=new java.sql.Date(millis);
	        userDao.insert(new UserModel(roleid, username,email,password,password, password, roleid, password, date));
	        return true;
	    }
	    @Override
	    public boolean checkExistEmail(String email) {
	        return userDao.checkExistEmail(email);
	    }
	    @Override
	    public boolean checkExistUsername(String username) {
	        return userDao.checkExistUsername(username);
	    }

		
}
