package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.EmployeesController;

/**
 * Servlet implementation class DisplayAllEmployees
 */
@WebServlet("/DisplayAllEmployees")
public class DisplayAllEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllEmployees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
	    try{
	    	out.println("<html>");
	    ResultSet rs=EmployeesController.displayAll();
	    if(rs.next())
	    { out.println("<center><table border=1>");
	    out.println("<caption><b><i>List of Employees</i></b></caption>");
	    
	    	    out.println("<tr><th>Employee</th><th>DOB<br>Gender</th><th>Address</th><th>Contact<br>Information</th><th>Designation<br>Salary</th><th>Update</th></tr>");
	    do{
	    out.println("<tr><td>"+rs.getString(2)+"<br><img src='/Parking/images/"+rs.getString(12)+"' width=25 height=25><br>"+rs.getString(1)+"</td><td>"+rs.getString(4)+"<br>"+rs.getString(3)+"</td><td>"+rs.getString(5)+"<br>"+rs.getString(14)+","+rs.getString(13)+"</td><td>"+rs.getString(10)+"<br>"+rs.getString(11)+"</td><td>"+rs.getString(8)+"<br>"+rs.getString(9)+"</td><td><a href=EditDeleteDisplayByID?eid="+rs.getString(1)+">Edit/Delete</a></td></tr>");	
	    	
	    }while(rs.next());
	    out.println("</table></center>"); 	
	    	
	    }
	    else
	    {out.println("<h1>Record Not Found...</h1>");}
	    	
	    }catch(Exception e){
	    System.out.println(e);	
	    	
	    }
	    out.println("</html>");
	
	}

}







