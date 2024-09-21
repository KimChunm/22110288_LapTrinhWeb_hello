package vn.iostrar.dao;


import java.util.List;

import vn.iostrar.models.UserModel;

public interface IUserDao {
    UserModel findByUserName(String userName);
    List<UserModel> findAll();
    UserModel findById(int id);
    void insert(UserModel user);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    UserModel findByUsernameAndEmail(String username, String email);
    boolean updatePassword(String username, String password);
}