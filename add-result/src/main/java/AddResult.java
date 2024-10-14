

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddResult extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    
	
		int id=Integer.parseInt(request.getParameter("id"));
		//request.parameter
		//we are converting id from string to integer by using parseInt()
			
		String name=request.getParameter("name");
		//name is required in the string format.therefore we are not converting into an int.
		
		int marks1=Integer.parseInt(request.getParameter("marks1"));
		int marks2=Integer.parseInt(request.getParameter("marks2"));
		int marks3=Integer.parseInt(request.getParameter("marks3"));
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","Nikhitapr@123");
			
			String s="insert into student2 values(?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(s);
			pstmt.setInt(1,id);
			pstmt.setString(2,name);
			pstmt.setInt(3, marks1);
			pstmt.setInt(4, marks2);
			pstmt.setInt(5, marks3);
			int rows=pstmt.executeUpdate();
			PrintWriter out=response.getWriter();
			if(rows==0) {
				out.println("Student data not added");
			}
			else {
				out.println("Student data added successfully");
			}
		}
			catch(Exception e) {
				e.printStackTrace();
			}
			
	   }
  }

	
 