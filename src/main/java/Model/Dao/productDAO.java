package Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import Model.Bean.*;
import java.sql.SQLException;

public class productDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<product> getAllProduct() {
		List<product> list = new ArrayList<>();
		String query = "select * from product";
		try {
			conn = ConnectDB.getConnection();
			ps = conn.prepareStatement (query);
			rs=ps.executeQuery();
			while (rs.next()) {
				list.add(new product (rs.getInt(1),
									  rs.getString (2),
									  rs.getString (3),
									  rs.getDouble (4),
									  rs.getString (5),
									  rs.getString (6),
				                      rs.getInt(7)));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public List<product> getProductByCID(String cid) {
		List<product> list = new ArrayList<>();
		String query = "select * from product where cateID = ? ";
		try {
			conn = ConnectDB.getConnection();
			ps = conn.prepareStatement (query);
			ps.setString(1,cid);
			rs=ps.executeQuery();
			while (rs.next()) {
				list.add(new product  (rs.getInt(1),
						  rs.getString (2),
						  rs.getString (3),
						  rs.getDouble (4),
						  rs.getString (5),
						  rs.getString (6),
	                      rs.getInt(7)));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public product getProductByID(String id) {
		String query = "select * from product where id = ? ";
		try {
			conn = ConnectDB.getConnection();
			ps = conn.prepareStatement (query);
			ps.setString(1,id);
			rs=ps.executeQuery();
			while (rs.next()) {
				return (new product  (rs.getInt(1),
						  rs.getString (2),
						  rs.getString (3),
						  rs.getDouble (4),
						  rs.getString (5),
						  rs.getString (6),
	                      rs.getInt(7)));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public product getLast() {
		String query = "select top 1 * from product\n" + "order by id desc";
		try {
			conn = ConnectDB.getConnection();
			ps = conn.prepareStatement (query);
			rs=ps.executeQuery();
			while (rs.next()) {
				return new product (rs.getInt(1),
						  rs.getString (2),
						  rs.getString (3),
						  rs.getDouble (4),
						  rs.getString (5),
						  rs.getString (6),
	                      rs.getInt(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<product> searchByName(String txtSearch) {
		List<product> list = new ArrayList<>();
		String query = "select * from product where [name] like ?";
		try {
			conn = ConnectDB.getConnection();
			ps = conn.prepareStatement (query);
			ps.setString(1, "%"+txtSearch+"%");
			rs=ps.executeQuery();
			while (rs.next()) {
				list.add(new product  (rs.getInt(1),
						  rs.getString (2),
						  rs.getString (3),
						  rs.getDouble (4),
						  rs.getString (5),
						  rs.getString (6),
	                      rs.getInt(7)));
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public List<product> getProductBySellID(int id) { 
		List<product> list = new ArrayList<>(); 
		String query = "select * from product\n" + "where sell_ID = ?";
		try {
			conn = ConnectDB.getConnection();//mo ket noi voi sql
			ps = conn.prepareStatement (query);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while (rs.next()) {
				list.add(new product (rs.getInt(1),
						  rs.getString (2),
						  rs.getString (3),
						  rs.getDouble (4),
						  rs.getString (5),
						  rs.getString (6),
	                      rs.getInt(7)));
			}
		}catch(Exception e) {
			
		}
		return list;
	}
	public List<product> getProductBysellID(int id) {
		List<product> list = new ArrayList<>();

	    String query = "SELECT * FROM product WHERE sell_id = ?";
	    try {
	        conn = ConnectDB.getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, id);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	        	list.add(new product(rs.getInt(1),
						  rs.getString (2),
						  rs.getString (3),
						  rs.getDouble (4),
						  rs.getString (5),
						  rs.getString (6),
	                      rs.getInt(7)));
	        }
	    } catch (SQLException e) {
	        // Handle the exception, log or rethrow if necessary
	        e.printStackTrace();
	    }
	    return list;
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		productDAO a = new productDAO();
		product b = a.getProductByID("23");
		String name = b.getName();
		double money = b.getPrice();
		String image = b.getImage();
		System.out.println(name);
		System.out.println(money);
		System.out.println(image);
				
	}

	public void deleteProduct(String pid) {
		// TODO Auto-generated method stub
		String query = "delete from product\n" +"where id= ?";
		try {
		conn = ConnectDB.getConnection();//mo ket noi voi sql
		ps = conn.prepareStatement (query);
		ps.setString (1, pid);
		ps.executeUpdate();
		} catch(Exception e) {} 
		
	}

	public void insertProduct(String pname, String pimage, String pprice, String ptitle, String pdescription,
            String pcategory, int sid) {
// Avoid duplicate function definition

		String query = "INSERT INTO [dbo].[product] " +
				"([name], [image], [price], [title], [description], [cateID], [sell_ID]) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn =  ConnectDB.getConnection()) { // Use try-with-resources for resource management
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, pname);
			ps.setString(2, pimage);
			ps.setString(3, pprice);
			ps.setString(4, ptitle);
			ps.setString(5, pdescription);
			ps.setString(6, pcategory);
			ps.setInt(7, sid);
			ps.executeUpdate();
		} catch (Exception e) {
			// Handle any database exceptions here
			e.printStackTrace();
		}
	}
	
	public void editProduct(String name, String image, String price, String title, String description, String category, String pid) {
	    String query = "UPDATE product SET "
	        + "name = ?, "
	        + "image = ?, "
	        + "price = ?, "
	        + "title = ?, "
	        + "description = ?, "
	        + "cateID = ? "
	        + "WHERE id = ?";

	    try {
	        // Sử dụng try-with-resources để tự động đóng kết nối
	        try (Connection conn = ConnectDB.getConnection();
	            PreparedStatement ps = conn.prepareStatement(query)) {
	            ps.setString(1, name);
	            ps.setString(2, image);
	            ps.setString(3, price);
	            ps.setString(4, title);
	            ps.setString(5, description);
	            ps.setString(6, category);
	            ps.setString(7, pid);
	            ps.executeUpdate();
	        }
	    } catch (Exception e) {
	        // Xử lý lỗi và in ra thông tin lỗi
	        e.printStackTrace();
	    }
	}


}
