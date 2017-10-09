package com.Leon.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import sun.rmi.runtime.Log;

/**
 * Servlet implementation class Log4jDemo
 */
public class Log4jDemo extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Log4jDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn =null;
		String sql = "insert into t_book values(?,?,?,?)";
		String url="jdbc:log4jdbc:mysql://localhost:3306/bookdb?";
		String user ="root";
		String password="root";
		String driver_ClassName = "net.sf.log4jdbc.DriverSpy";

		try {
			Class.forName(driver_ClassName);
			conn=DriverManager.getConnection(url,user,password);
			
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, 10);
			pstmt.setString(2, "ƒ„∫√ ¿ΩÁ");
			pstmt.setInt(3, 10);
			pstmt.setString(4, "1234");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
