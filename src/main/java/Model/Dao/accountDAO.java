package Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Bean.*;

public class accountDAO {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public account login(String user,String pass) {
		String query = "select * from account where username = ? and pass = ?";
		try {
			conn = ConnectDB.getConnection();
			ps = conn.prepareStatement (query);
			ps.setString(1,user);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			while (rs.next()) {
				return (new account (rs.getInt(1),
									  rs.getString(2),
									  rs.getString(3),
									  rs.getString(4),
									  rs.getString(5)));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public account checkAccountExist(String user) {
		String query = "select * from account where username = ? ";
		try {
			conn = ConnectDB.getConnection();
			ps = conn.prepareStatement (query);
			ps.setString(1,user);
			rs=ps.executeQuery();
			while (rs.next()) {
				return (new account (rs.getInt(1),
									  rs.getString (2),
									  rs.getString (3),
									  rs.getString(4),
									  rs.getString(5)));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public account singup (String user, String pass) {
		String query = "insert into account\n" + "values (?,?,1,0)";
		try {
			conn = ConnectDB.getConnection(); //mo ket noi voi sql 
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2,pass);
			ps.executeUpdate();
		} catch (Exception e) {
		}
		return null;
	}
	
	public boolean CheckLoginAdmin(String user, String pass) {
	    String query = "SELECT * FROM account WHERE username = ? AND pass = ? AND isAdmin = '1' ";
	    try (Connection conn = ConnectDB.getConnection();
	         PreparedStatement ps = conn.prepareStatement(query)) {
	        ps.setString(1, user);
	        ps.setString(2, pass);
	        ResultSet rs = ps.executeQuery();

	        // If user is found, return true
	        if (rs.next()) {
	            return true;
	        }
	    } catch (SQLException e) {
	        // Log the error
	        e.printStackTrace();
	    }
	    return false;
	}

	public List<account> getAllAccount() {
			List<account> list = new ArrayList<>();
			String query = "select * from account";
			try {
				conn = ConnectDB.getConnection();
				ps = conn.prepareStatement (query);
				rs=ps.executeQuery();
				while (rs.next()) {
					list.add(new account (rs.getInt(1),
							  rs.getString (2),
							  rs.getString (3),
							  rs.getString(4),
							  rs.getString(5)));
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return list;
			
	}

	public void deleteAccount(String aid) {
		// TODO Auto-generated method stub
		String query = "delete from account\n" +"where uID= ?";
		try {
		conn = ConnectDB.getConnection();//mo ket noi voi sql
		ps = conn.prepareStatement (query);
		ps.setString (1, aid);
		ps.executeUpdate();
		} catch(Exception e) {} 
	}

	public void insertAccount(String pname, String ppass) {
		String query = "insert into account\n" + "values (?,?,0,1)";
		try {
			conn = ConnectDB.getConnection(); //mo ket noi voi sql 
			ps = conn.prepareStatement(query);
			ps.setString(1, pname);
			ps.setString(2,ppass);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public account getAccountByID(String id) {
		String query = "select * from account where uID=? ";
		try {
			conn = ConnectDB.getConnection();
			ps = conn.prepareStatement (query);
			ps.setString(1,id);
			rs=ps.executeQuery();
			while (rs.next()) {
				return (new account (rs.getInt(1),
									  rs.getString (2),
									  rs.getString (3),
									  rs.getString(4),
									  rs.getString(5)));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public void editAccount(String pname, String ppass, String pid) {
	    String query = "UPDATE account SET "
		        + "username = ?, "
		        + "pass = ? "
		        + "WHERE uID = ?";

		    try {
		        // Sử dụng try-with-resources để tự động đóng kết nối
		        try (Connection conn = ConnectDB.getConnection();
		            PreparedStatement ps = conn.prepareStatement(query)) {
		            ps.setString(1, pname);
		            ps.setString(2, ppass);
		            ps.setString(7, pid);
		            ps.executeUpdate();
		        }
		    } catch (Exception e) {
		        // Xử lý lỗi và in ra thông tin lỗi
		        e.printStackTrace();
		    }
		
	}

	
	
}
