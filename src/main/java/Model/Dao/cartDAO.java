package Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Bean.cart;
import Model.Bean.product;

public class cartDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public void insertToCart(int id, String name, String image, double price) {
		String query = "INSERT INTO [dbo].[cart] " +
				"([uID], [name], [price], [image]) " +
				"VALUES (?, ?, ?, ?)";
		try {
			conn = ConnectDB.getConnection(); //mo ket noi voi sql 
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2,name);
			ps.setDouble(3,price);
			ps.setString(4,image);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}
	
	public static void main(String[] args) {
		cartDAO a = new cartDAO();
		a.insertToCart(1, "bú lul", "123", 300);
	}

	public List<cart> getAllCart(int id) {
		// TODO Auto-generated method stub
		List<cart> list = new ArrayList<>();
		String query = "select * from cart where uID = "+id;
		try {
			conn = ConnectDB.getConnection();
			ps = conn.prepareStatement (query);
			rs=ps.executeQuery();
			while (rs.next()) {
				list.add(new cart (rs.getInt(1),
								   rs.getString (2),
								   rs.getDouble (3),
								   rs.getString (4)));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public void Buy(int id) {
		String query = "delete from cart\n" +"where uID= ?";
		try {
		conn = ConnectDB.getConnection();//mo ket noi voi sql
		ps = conn.prepareStatement (query);
		ps.setInt (1, id);
		ps.executeUpdate();
		} catch(Exception e) {} 
	}
}
