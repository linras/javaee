package aformela.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aformela.shop.domain.Bird;
import aformela.shop.service.StorageService;

@WebServlet(urlPatterns = "/data")
public class DataServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// zapewnia istnienie StorageService'a
		StorageService storageS = (StorageService) request.getSession().getServletContext().getAttribute("storage");
		if(storageS == null) {
			storageS = new StorageService();
			request.getSession().getServletContext().setAttribute("storage", storageS);
		}
		response.setContentType("text/html");
		//StorageService storage = new StorageService();
		PrintWriter out = response.getWriter();
		
		/*String selected = "";
		for (String bird : request.getParameterValues("bird")) {
			selected += bird + " ";
		}*/
		Bird newBird = new Bird(request.getParameter("name"),
				request.getParameter("dateOfBirth"),
				Boolean.parseBoolean(request.getParameter("female")),
				Double.parseDouble(request.getParameter("price")),
				Integer.parseInt(request.getParameter("countOfColors"))
				);
		storageS.add(newBird);
		out.println("<html><body><h2>You added:</h2>" +
				"<p> Name: " + request.getParameter("name") + "<br />" +
				"Date of birth: " + request.getParameter("dateOfBirth") + "<br />" +
				"Is female: " + request.getParameter("female") + "<br />" +
				"Price: " + request.getParameter("price") + "<br />" +
				"Count of colors: " + request.getParameter("countOfColors") + "<br />" +
				"<a href='seeAll'> See all birds in the shop </a>" +
				"</br><a href='index.jsp'>back to menu</a>"+
				"</body></html>");
		out.close();
	}

}
