package aformela.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aformela.shop.domain.Bird;
import aformela.shop.service.StorageService;

@WebServlet(urlPatterns = "/seeAll")
public class SeeAllServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object lala = request.getSession().getServletContext().getAttribute("storage");
		StorageService storageS = (StorageService) lala;
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>All birds:</h2>");
		for (Bird bird : storageS.getAllBirds()) {
			  out.println("<p>Name: " + bird.getName() + "; Price: " + bird.getPrice()+"; Date of birth: "+bird.getDateOfBirth() + "; Is Female: "+bird.isFemale()+"; Has "+bird.getCountOfColors()+" colors;"+"</p>");
		  }

		out.println("</br><a href='index.jsp'>back to menu</a>");
		out.println("</body></html>");
		out.close();
	}

}