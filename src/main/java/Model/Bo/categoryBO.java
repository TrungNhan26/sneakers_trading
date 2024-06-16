package Model.Bo;

import java.sql.SQLException;
import java.util.List;

import Model.Bean.*;
import Model.Dao.*;

public class categoryBO {
	categoryDAO categoryDAO = new categoryDAO();
	
	public List<category> listCategory() throws ClassNotFoundException, SQLException {
		return categoryDAO.getAllCategory();
	}
}

