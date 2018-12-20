package aformela.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aformela.shop.domain.Bird;
import aformela.shop.service.StorageService;

@WebServlet(urlPatterns = "/shopping")
public class ShoppingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext application = getServletConfig().getServletContext();
		// zapewnia istnienie StorageService'a
		StorageService storageS = (StorageService) request.getSession().getServletContext().getAttribute("storage");
		if(storageS == null) {
			storageS = new StorageService();
			request.getSession().getServletContext().setAttribute("storage", storageS);
		}

		
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		//if(session.getAttribute("user")!=null)
		PrintWriter out = response.getWriter();
		//out.println(session.getId());
		if(storageS.getAllBirds().isEmpty())
			storageS.addExamples();
		out.println("<html><body><h2>Shopping</h2>" +
				"<form action='trolley' method = 'GET'>");
		if(storageS.getAllBirds()!=null) {
			for (Bird bird : storageS.getAllBirds()) { 
				out.println("<input type=\'checkbox\' name=\'bird' value=\'"+
				storageS.getAllBirds().indexOf(bird)+"\'> "+bird.toString()+" <br >");
				
			}
		}
				
				
				
		out.println("<input type='submit' value=' OK ' />" +
				"</form>" +
				"</br><a href='index.jsp'>back to menu</a>"+
				"</body></html>");
		out.close();
	}

}
