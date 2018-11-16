package aformela.shop.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aformela.shop.domain.Bird;
import aformela.shop.service.StorageService;

@WebServlet(urlPatterns = "/yourSurvey")
public class yourSurveyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		StorageService storageS = (StorageService) request.getSession().getServletContext().getAttribute("storage");
		StorageService sessionStorage = (StorageService) request.getSession().getAttribute("sessionStorage");
		if(storageS == null) {
			storageS = new StorageService();
			request.getSession().getServletContext().setAttribute("storage", storageS);
		}
		if(sessionStorage == null) {
			sessionStorage = new StorageService();
			request.getSession().setAttribute("sessionStorage", sessionStorage);
		}
		
		
		String selectedBirds = "";
		if(request.getParameterValues("bird")!=null) {
			for (String nr : request.getParameterValues("bird")) {
				selectedBirds += nr + " ";
				Bird newBird = storageS.getAllBirds().get(Integer.parseInt(nr));
				sessionStorage.add(newBird);
			}
		}
		
		if(sessionStorage.getAllBirds()!=null) {
			out.println("<h2>YOUR SURVEYS:</h2>");
			for(Bird bird : sessionStorage.getAllBirds()) {
				out.println(bird+"</br>");
			}
		}
		out.println(selectedBirds);
		out.println("</br><a href='index.jsp'>back to menu</a>");

		out.println("</body></html>");
		out.close();
	}

}
