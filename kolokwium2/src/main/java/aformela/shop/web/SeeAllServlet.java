package aformela.shop.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aformela.shop.domain.Button;
import aformela.shop.service.StorageService;

@WebServlet(urlPatterns = "/seeAll")
public class SeeAllServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object lala = request.getSession().getServletContext().getAttribute("appStorage");
		StorageService appStorage = (StorageService) lala;
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>All buttons:</h2>");
		if(appStorage.getButtons().isEmpty()){
			try {
				appStorage.addSomeButtons();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	  for (Button b : appStorage.getButtons()) {
		  out.print("<br>");
		  out.print(b.toString());
	  }
		

		out.println("</br><a href='index.jsp'>back to menu</a>");
		out.println("</body></html>");
		out.close();
	}

}