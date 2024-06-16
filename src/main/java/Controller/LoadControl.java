package Controller;

import java.io.IOException;
import java.sql.SQLException;
import Model.Dao.*;
import Model.Bean.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadControl
 */
@WebServlet("/load")
public class LoadControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
			response.setContentType("text/html;charset=UTF-8");
			String id=request.getParameter("pid");
			productDAO Pdao=new productDAO();
			product p=Pdao.getProductByID(id);
			categoryDAO Cdao=new categoryDAO(); 
			List<category> listC= Cdao.getAllCategory();
			request.setAttribute("listCC",listC);
			request.setAttribute("detail", p);
			request.getRequestDispatcher("Edit.jsp").forward(request, response);
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
