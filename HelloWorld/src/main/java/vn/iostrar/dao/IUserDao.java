package vn.iostrar.dao;

import java.util.List;

import vn.iostrar.models.UserModel;

public interface IUserDao {
	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	void insert(UserModel user);

}
