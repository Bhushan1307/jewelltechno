package com.bhushan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	String url = "jdbc:mysql://localhost:3306/db"; 
    	String username = "root";
    	String password = "root";
    	Connection conn = DriverManager.getConnection(url, username, password);
    	Statement stm = conn.createStatement();
    	int id=4;
    	ResultSet rs = stm.executeQuery("SELECT * FROM student WHERE id= "+id);
    	while (rs.next()) {
			System.out.println(rs.getInt("id")+ " " +rs.getString("name"));
		}
    	conn.close();
    }
}
