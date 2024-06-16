package Model.Bo;

import Model.Bean.*;
import Model.Dao.*;

public class accountBO {
	accountDAO accountDAO = new accountDAO();
	
	public account logIn(String user,String pass) {
		// TODO Auto-generated method stub
		return accountDAO.login(user,pass);
	}

	public account checkAccountExist(String user) {
		// TODO Auto-generated method stub
		return accountDAO.checkAccountExist(user);
	}

	public account signUp(String user, String pass) {
		// TODO Auto-generated method stub
		return accountDAO.singup(user, pass);
		
	}
	
	public boolean CheckLoginAdmin(String user,String pass) {
		return accountDAO.CheckLoginAdmin(user, pass);
	}
}
