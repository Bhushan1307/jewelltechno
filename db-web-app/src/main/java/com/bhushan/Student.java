package com.bhushan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")
public class Student extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
   
    public Student() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sn = request.getParameter("q");
	
	  String sName = null;
	  try{
			
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url = "jdbc:mysql://localhost:3306/db"; 
    	String username = "root";
    	String password = "root";
    	Connection conn = DriverManager.getConnection(url, username, password);
    	Statement stm = conn.createStatement();

    	ResultSet rs =	stm.executeQuery("SELECT * FROM student WHERE id= " + sn);
    	
    	while(rs.next()) {
    		sName = rs.getString("name");
    	}
    	conn.close();
    	
     } catch (ClassNotFoundException e) {
    	 e.printStackTrace();
	 } catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("data", "Welcome " + sName);
		request.getRequestDispatcher("student.jsp").forward(request,response);	
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
