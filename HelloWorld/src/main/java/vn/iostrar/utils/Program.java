package vn.iostrar.utils;

import vn.iostrar.services.impl.UserService;

public class Program {
    public static void main(String[] args) {
        UserService user = new UserService();
        System.out.println(user.findByUserName("1"));
    }
}
