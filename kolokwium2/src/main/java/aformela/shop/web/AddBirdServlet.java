package aformela.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/addBird")
public class AddBirdServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Adding bird to the shop</h2>" +
		
				"<form action='data' method = 'GET'>" +
				"<input type='text' name='name' >Name<br />" +
				"<input type='text' name='dateOfBirth' >Date of birth<br />" +
				"<input type='text' name='female' >Is female?<br />" +
				"<input type='text' name='price' >Price<br />" +
				"<input type='text' name='countOfColors' >Count of colors<br />" +
				"<input type='submit' value=' OK ' />" +
				"</form>" +
				"</br><a href='index.jsp'>back to menu</a>"+
				"</body></html>");
		out.close();
	}

}