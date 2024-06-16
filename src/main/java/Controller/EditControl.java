package Controller;

import java.io.IOException;
import java.sql.SQLException;
import Model.Dao.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditControl
 */
@WebServlet("/edit")
public class EditControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
			response.setContentType("text/html;charset=UTF-8");
			String Pid=request.getParameter("id");
			String Pname=request.getParameter("name");
			String Pimage=request.getParameter("image");
			String Pprice=request.getParameter("price");
			String Ptitle=request.getParameter("title");
			String Pdescription=request.getParameter("description");
			String Pcategory=request.getParameter("category");
			productDAO Pdao=new productDAO();
			Pdao.editProduct(Pname,Pimage,Pprice,Ptitle,Pdescription,Pcategory,Pid);
			response.sendRedirect("manager");
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
