package vn.iostrar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iostrar.dao.IUserDao;
import vn.iostrar.models.UserModel;

public class UserDaoImpl implements IUserDao {
	public UserModel findByUsername(String username) {
		String sql = "select * from users where username = ?";
		try {
			Connection conn = new DBConnectSQL().getConnection();
			PreparedStatement ps = conn.prepareSatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next())	{
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user. setFullname (String password ring ( "fullname"));
				user. setPassword (sq]) ;
			} catch (Exception e) {
				e.printStackTrace();
				}	
			}
		return null;
	}

}
