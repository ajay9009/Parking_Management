package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.nis.controller.VehiclesController;

/**
 * Servlet implementation class DisplayAllVehicles
 */
@WebServlet("/DisplayAllVehicles")
public class DisplayAllVehicles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllVehicles() {
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
	    ResultSet rs=VehiclesController.displayAll();
	    if(rs.next())
	    { out.println("<center><table border=1>");
	    out.println("<caption><b><i>List of Vehicles</i></b></caption>");
	    
	   out.println("<tr><td>Employeeid</td><td>Vehicleid</td><td>Referrenceid</td><td>floorid</td><td>Mobileno</td><td>Currentdate<br>Currenttime</td><td>Time</td><td>Amount</td><td>status</td><td>Update</tr>");
	    do{
	    out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"<br>"+rs.getString(6)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(9)+"</td><td>"+"<a href=EditDeleteDisplayVehiclesByID?vid="+rs.getString(2)+">Edit/Delete</a></td></tr>");	
	    	
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
