package com.example.servletdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/about")
public class AboutServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
        
		response.setContentType("text/html");
		ReadFile file = new ReadFile("strona.txt");
		PrintWriter out = response.getWriter();
		String s = file.read();
		out.print(s);
		
		//out.print("<html><body><h1>Antonina</h1><br><p>akapit 1</p><p>akapit2</p><ul>Moja lista jest: <li>super</li><li>taka ciekawa</li></ul></body></html>");
	}
	
	public String odczyt(String nazwa) throws FileNotFoundException {
		String s ="";
		File plik = new File(nazwa);
		Scanner odczyt = new Scanner(new File(nazwa));
		while(odczyt.hasNext()) {
			s = s + odczyt.nextLine();
		}
		return s;
	}
		

}
