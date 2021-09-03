package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.VehiclesController;
import com.nis.model.Vehicles;


/**
 * Servlet implementation class EditDeleteDisplayVehiclesByID
 */
@WebServlet("/EditDeleteDisplayVehiclesByID")
public class EditDeleteDisplayVehiclesByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDeleteDisplayVehiclesByID() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
        out.println("<html>");
		Vehicles V=VehiclesController.displayByID(Integer.parseInt(request.getParameter("vid"))); 		
		if(V!=null)
		{
			out.println("<html><form action='FinalEditDeleteVehicle' method='post'>");
			out.println("<table><caption><b><i>Vehicle Registration</i></b></caption>");
			
			out.println("<tr><td><b><i>Employee Id:</i></b></td>");
		    out.println("<td><input type='text' name='eid' value='"+V.getEmployeeid()+"'></td></tr>");

		    out.println("<tr><td><b><i>Vehicle Id:</i></b></td>");
		    out.println("<td><input type='text' name='vid' value='"+V.getVehicleid()+"'></td></tr>");
		    
		    out.println("<tr><td><b><i>RFID no:</i></b></td>");
		    out.println("<td><input type='text' name='vrfid' value='"+V.getRefernceid()+"'></td></tr>");
		    
		    out.println("<tr><td><b><i>Mobileno no:</i></b></td>");
		    out.println("<td><input type='text' name='vmob' value='"+V.getMobileno()+"'></td></tr>");
		    
		    out.println("<tr><td><b><i>Current date:</i></b></td>");
		    out.println("<td><input type='date' name='vcdate' value='"+V.getCurrentdate()+"'></td></tr>");
		    
		    out.println("<tr><td><b><i>Current time:</i></b></td>");
		    out.println("<td><input type='time' name='vctime' value='"+V.getCurrenttime()+"'></td></tr>");
		    
		    out.println("<tr><td><b><i>Amount:</i></b></td>");
		    out.println("<td><input type='text' name='vamt' value='30'></td></tr>");
		    
		    out.println("<tr><td><b><i>time:</i></b></td>");
		    out.println("<td><select name='vtime'><option value='1'>1</option><option value='2'>2</option><option selected value='3'>3</option><option value='4'>4</option></select></td></tr>");
		    
		    out.println("<tr><td><b><i>status:</i></b></td>");
		    out.println("<td><select name='vstatus'><option selected value='in'>in</option><option value='out'>out</option></select>");
		    
		    out.println("<tr><td><b><i>Floor no:</i></b></td>");
		    out.println("<td><input type='text' name='vfno' value='"+V.getFloorno()+"'></td></tr>");
		    
		    out.println("</table><br><br>");
		    
		    out.println("<input type='submit' value='Edit' name='btn'>  <input type='Submit' value='Delete' name='btn'></form>");
			
		}
		else
		{
		out.println("Record Not Found....");	
		}
		
		out.println("</html>");
	}
}
