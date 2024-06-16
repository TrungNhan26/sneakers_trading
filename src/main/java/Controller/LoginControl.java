package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.Dao.*;
import Model.Bo.*;
import Model.Bean.*;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/login")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        accountDAO Abo = new accountDAO();
        account a = Abo.login(username, password);
        boolean b = Abo.CheckLoginAdmin(username, password);
        if (a== null) {
        	request.setAttribute("mess", "Wrong user or pass");
        	request.getRequestDispatcher ("Login.jsp"). forward (request, response); 
        }
        if (a!= null){
        	if(!b) {
        		HttpSession session = request.getSession();
        		session.setAttribute("acc", a);
        		session.setMaxInactiveInterval(600);
        		response.sendRedirect("home");
                //request.getRequestDispatcher("Home.jsp").forward(request, response);
        	}
        	else {
        		response.sendRedirect("ADControl");
        		//request.getRequestDispatcher("").forward(request, response);
        	}
        }
	}
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
			processRequest(request, response);
		} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
			processRequest(request, response);
		} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
