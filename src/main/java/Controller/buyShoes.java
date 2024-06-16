package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Bean.account;
import Model.Bean.product;
import Model.Dao.cartDAO;
import Model.Dao.productDAO;

/**
 * Servlet implementation class buyShoes
 */
@WebServlet("/buy")
public class buyShoes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
			response.setContentType("text/html;charset=UTF-8");
			HttpSession session = request.getSession();
			account a=(account) session.getAttribute("acc");
			int id =a.getId();
			cartDAO cart = new cartDAO();
			cart.Buy(id);
			response.sendRedirect("home");
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
