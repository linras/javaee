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

@WebServlet(urlPatterns = "/opinionData")
public class OpinionDataServlet extends HttpServlet {

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
		String opinia = request.getParameter("name");
		storageS.addOpinion(opinia);
		out.println("<html><body><h2>You added:</h2>" +
				"<p> Name: " + request.getParameter("name") + "<br />" +
				"</br><a href='index.jsp'>back to menu</a>"+
				"</body></html>");
		out.close();
	}

}
