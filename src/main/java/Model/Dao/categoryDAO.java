package Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Bean.*;

public class categoryDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<category> getAllCategory() {
		List<category> list = new ArrayList<>();
		String query = "select * from category";
		
		try {
			conn = ConnectDB.getConnection();
			ps = conn.prepareStatement (query);
			rs=ps.executeQuery();
			while (rs.next()) {
			list.add(new category (rs.getInt(1),
								   rs.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
}
