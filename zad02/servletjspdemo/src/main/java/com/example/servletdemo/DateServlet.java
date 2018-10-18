package com.example.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/date")
public class DateServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		ReadFile file = new ReadFile("date.txt");
		String s = file.read();
		s = s+dateFormat.format(date)+"</p></h1>\r\n" + 
				"    </div>\r\n" + 
				"  \r\n" + 
				"</body>\r\n" + 
				"</html>";
		out.print(s);
		
		//out.println("<html><body><h1>Dzisiejsza data: "+dateFormat.format(date)+"</h1></body></html>"); //2016/11/16 12:08:43
		//out.print("Hello");
	}
}