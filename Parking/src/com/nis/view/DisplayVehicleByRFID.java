package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayVehicleByRFID
 */
@WebServlet("/DisplayVehicleByRFID")
public class DisplayVehicleByRFID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayVehicleByRFID() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<script src='/Parking/asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='/Parking/asset/vehicle.js'></script>");
		out.println("<html><center>");
		out.println("<table width=50%><caption><b><i>Search Vehicle By RFID</i></b></caption>");
		
		out.println("<tr><td><b><i>RFID Number:</i></b></td>");
	    out.println("<td><input type='text' id='rfid'></td><td><input type='button' id='btn' value='Search'></td></tr>");
	    out.println("</table><br>");
	    out.println("<div id='result'></div>");
	    out.println("</html>");
	    
	    
	    
	}

}
