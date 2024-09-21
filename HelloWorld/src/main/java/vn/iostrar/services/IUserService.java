package vn.iostrar.services;

import vn.iostrar.models.UserModel;

public interface IUserService {
    UserModel login(String username, String password);
    UserModel findByUserName(String username);
    UserModel findByUsernameAndEmail(String username, String email);
    boolean updatePassword(String username,String newPassword);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);

    boolean register(String username, String email, String password, int i);
}
