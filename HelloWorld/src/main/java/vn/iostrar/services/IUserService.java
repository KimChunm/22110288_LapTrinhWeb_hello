package vn.iostrar.services;

import vn.iostrar.models.UserModel;

public interface IUserService {
	UserModel findByUserName(String username);
	

}
