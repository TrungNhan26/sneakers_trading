package Model.Bo;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.Bean.*;

import Model.Dao.*;

public class productBO {
	productDAO productDAO = new productDAO();
	
	public List<product> listProduct() throws ClassNotFoundException, SQLException {
		return productDAO.getAllProduct();
	}

	public product getLast() {
		// TODO Auto-generated method stub
		return productDAO.getLast();
	}
	
	public List<product> listProductByCID(String cid) throws ClassNotFoundException, SQLException {
		return productDAO.getProductByCID(cid);
	}
	
	public product productByID(String id)throws ClassNotFoundException, SQLException {
		return productDAO.getProductByID(id);
	}
	
	public List<product> searchByName(String txtSearch) throws ClassNotFoundException, SQLException {
		return productDAO.searchByName(txtSearch);
	}
	
}
