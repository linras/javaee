package com.example.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		ReadFile file = new ReadFile("menu.txt");
		String s = file.read();
		out.print(s);
		/*
		out.println("<html><body>Przejdz do: <a href=\"http://localhost:8080/servletjspdemo/about\">ABOUT</a></br>");
		out.println("Przejdz do: <a href=\"http://localhost:8080/servletjspdemo/date\">DATE</a></body></html>");*/
	}
}