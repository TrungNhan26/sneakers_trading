package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.Bean.*;
import Model.Dao.*;

/**
 * Servlet implementation class ManagerControl
 */
@WebServlet("/manager")
public class ManagerControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		account a=(account) session.getAttribute("acc");
		int id =a.getId();
		productDAO Pdao=new productDAO();
		categoryDAO Cdao = new categoryDAO();
		List<product> list = Pdao.getProductBysellID(id);
		List<category> listC= Cdao.getAllCategory();
		request.setAttribute("listCC",listC);
		request.setAttribute("listP",list);
		request.getRequestDispatcher("ManagerProduct.jsp").forward(request,response);
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
