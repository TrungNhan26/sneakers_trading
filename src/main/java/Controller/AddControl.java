package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.Bean.*;
import Model.Dao.*;

/**
 * Servlet implementation class AddControl
 */
@WebServlet("/add")
public class AddControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			// validate request, du lieu
			
			String pname=request.getParameter("name");
			String pimage=request.getParameter("image");
			String pprice=request.getParameter("price");
			String ptitle=request.getParameter("title");
			String pdescription=request.getParameter("description");
			String pcategory = request.getParameter("category");
			try {
				// insert
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			HttpSession session = request.getSession();
			account a=(account) session.getAttribute("acc");
			int userId = a.getId();
			productDAO Pdao=new productDAO();
			Pdao.insertProduct(pname,pimage,pprice,ptitle,pdescription,pcategory,userId);
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
