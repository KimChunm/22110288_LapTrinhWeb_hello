package vn.iostrar.dao.impl;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import configs.DBConnectSQLServer;
import vn.iostrar.dao.IUserDao;
import vn.iostrar.models.UserModel;

public class UserDaoImpl implements IUserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	public List<UserModel> findAll() {
		String sql = "SELECT * FROM Users ";
		List <UserModel> list = new ArrayList<UserModel>();
		try {
		conn = new DBConnectSQLServer().getConnection();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			list.add(new UserModel(
					rs.getInt("id"),
					rs.getString("username"),
					rs.getString("email"),
					rs.getString("fullname"),
					rs.getString("password"), 
					rs.getString("images"),
					rs.getInt("roleid"),
					rs.getString("phone"),
					rs.getDate("createDate")));
			return list; 
		}
	} catch (Exception e) {
		e.printStackTrace(); 
	}
	return null;
}

	@Override
	
	public UserModel findById(int id) {
		String sql = "SELECT * FROM Users WHERE id = ? ";
		try {
		conn = new DBConnectSQLServer().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		while (rs.next()) {
			UserModel user = new UserModel();
			user.setId(rs.getInt("id"));
			user.setEmail(rs.getString("email"));
			user.setUsername(rs.getString("username"));
			user.setFullname(rs.getString("fullname"));
			user.setPassword(rs.getString("password"));
			user.setImages(rs.getString("images"));
			user.setRoleid(Integer.parseInt(rs.getString("roleid")));
			user.setPhone(rs.getString("phone"));
			user.setCreateDate(rs.getDate("createDate"));
			return user; 
		}
	} catch (Exception e) {
		e.printStackTrace(); 
	}
	return null;
}
	public void insert(UserModel user)	{
		String sql = "INSERT INTO Users(id, username, password, images, fullname, email, phone, roleid, createDate) VALUE (?, ?, ?, ?, ?)";
		
				try {
					ps = conn.prepareStatement(sql); //nem cau lenh sql vao cho thuc thi
					
					ps.setInt(1, user.getId());
					ps.setString(2, user.getUsername());
					ps.setString(3, user.getPassword());
					ps.setString(4, user.getImages());
					ps.setString(5,  user.getFullname());
					
					ps.executeUpdate();	
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
	}

	@Override
	public UserModel findByUserName(String username) {
		String sql = "SELECT * FROM Users WHERE username = ? ";
		try {
		conn = new DBConnectSQLServer().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		rs = ps.executeQuery();
		while (rs.next()) {
			UserModel user = new UserModel();
			user.setId(rs.getInt("id"));
			user.setEmail(rs.getString("email"));
			user.setUsername(rs.getString("username"));
			user.setFullname(rs.getString("fullname"));
			user.setPassword(rs.getString("password"));
			user.setImages(rs.getString("images"));
			user.setRoleid(Integer.parseInt(rs.getString("roleid")));
			user.setPhone(rs.getString("phone"));
			user.setCreateDate(rs.getDate("createDate"));
			return user; 
		}
	} catch (Exception e) {
		e.printStackTrace(); 
	}
	return null;
}
	// Test chương trình. Kích phải chuột chọn run as->java application


		 public static void main(String[] args) {


		 try {
			 IUserDao userDao =new UserDaoImpl();
	
			 System.out.println(userDao.findById(1));
	
	
			 } catch (Exception e) {


		 e.printStackTrace();


			 }


		 }
		 public boolean checkExistUsername(String username) {
		        boolean duplicate = false;
		        String query = "select * from Users where username = ?";
		        try {
		            conn = new DBConnectSQLServer().getConnection();
		            ps = conn.prepareStatement(query);
		            ps.setString(1, username);
		            rs = ps.executeQuery();
		            if (rs.next()) {
		                duplicate = true;
		            }
		            ps.close();
		            conn.close();
		        } catch (Exception ex) {}
		        return duplicate;
		    }
		 public UserModel findByUsernameAndEmail(String username, String email) {
		        String sql = "SELECT * FROM users WHERE username = ? AND email = ?";
		        Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        UserModel user = null;

		        try {
		            con = new DBConnectSQLServer().getConnection(); // Tạo kết nối
		            ps = con.prepareStatement(sql); // Tạo PreparedStatement
		            ps.setString(1, username); // Set giá trị cho tham số username
		            ps.setString(2, email); // Set giá trị cho tham số password
		            rs = ps.executeQuery(); // Thực thi câu lệnh và lấy kết quả

		            // Kiểm tra nếu có dòng nào được trả về
		            if (rs.next()) {
		                // Lấy thông tin người dùng từ ResultSet và tạo đối tượng UserModel
		                user = new UserModel();
		                user.setEmail(rs.getString("email"));
		                user.setUsername(rs.getString("username"));
		                user.setFullname(rs.getString("fullname"));
		                user.setPassword(rs.getString("password"));
		                user.setRoleid(rs.getInt("roleid"));
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            // Đóng tài nguyên
		            try {
		                if (rs != null) rs.close();
		                if (ps != null) ps.close();
		                if (con != null) con.close();
		            } catch (Exception ex) {
		                ex.printStackTrace();
		            }
		        }

		        return user; // Trả về đối tượng UserModel hoặc null nếu không tìm thấy người dùng
		    }
		 public boolean updatePassword(String username, String newPassword) {
		        String sql = "UPDATE users SET password = ? WHERE username = ?";
		        Connection con = null;
		        PreparedStatement ps = null;
		        boolean isUpdated = false;

		        try {
		            con = new DBConnectSQLServer().getConnection(); // Tạo kết nối
		            ps = con.prepareStatement(sql); // Tạo PreparedStatement
		            ps.setString(1, newPassword); // Set mật khẩu mới
		            ps.setString(2, username); // Set giá trị cho tham số username
		            int rowsAffected = ps.executeUpdate(); // Thực thi câu lệnh cập nhật

		            // Kiểm tra số lượng dòng bị ảnh hưởng
		            if (rowsAffected > 0) {
		                isUpdated = true; // Cập nhật thành công
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            // Đóng tài nguyên
		            try {
		                if (ps != null) ps.close();
		                if (con != null) con.close();
		            } catch (Exception ex) {
		                ex.printStackTrace();
		            }
		        }

		        return isUpdated; // Trả về kết quả cập nhật
		    }

		    public boolean checkExistEmail(String email) {
		        boolean duplicate = false;
		        String query = "select * from users where email = ?";
		        try {
		            conn = new DBConnectSQLServer().getConnection();
		            ps = conn.prepareStatement(query);
		            ps.setString(1, email);
		            rs = ps.executeQuery();
		            if (rs.next()) {
		                duplicate = true;
		            }
		            ps.close();
		            conn.close();
		        } catch (Exception ex) {}
		        return duplicate;
		    }


}
