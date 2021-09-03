package com.nis.view;
import com.nis.generate.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VehicleView
 */
@WebServlet("/VehicleView")
public class VehicleView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
	   HttpSession ses=request.getSession();
	   int rn =Integer.parseInt(new String(GenerateOtp.sendOTP(8)));
		try{
			String nv="Employee Id:"+ses.getValue("EMPLOYEEID").toString()+"&nbsp;&nbsp;&nbsp;"+ses.getValue("EMPLOYEENAME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src='/Parking/images/"+ses.getValue("EMPLOYEEPICTURE")+"' width=30 height=30><hr color=red>";
	 
		}
	catch(Exception e)
	{
		response.sendRedirect("EmployeeLogin");
	}
		
		
		out.println("<script src='/Parking/asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='/Parking/asset/floor.js'></script>");
		out.println("<html><form action='VehiclesSubmit' method='post'>");
		out.println("<table><caption><b><i>Vehicle Registration</i></b></caption>");
		
		out.println("<tr><td><b><i>Employee Id:</i></b></td>");
	    out.println("<td><input type='text' name='eid' value="+ses.getValue("EMPLOYEEID")+"></td></tr>");
	    
	    out.println("<tr><td><b><i>RFID No.:</i></b></td>");
	    out.println("<td><input type='text' name='vrfid' value="+rn+"></td></tr>");
	    
	    out.println("<tr><td><b><i>Registration No.:</i></b></td>");
	    out.println("<td><input type='text' name='regno'></td></tr>");
	    
	    
	    
	    out.println("<tr><td><b><i>Mobile No.:</i></b></td>");
	    out.println("<td><input type='text' name='vmob'></td></tr>");
	    Calendar C=Calendar.getInstance();
	    String cd=C.get(Calendar.YEAR)+"/"+(C.get(Calendar.MONTH)+1)+"/"+C.get(Calendar.DATE);
	    String ct=C.get(Calendar.HOUR)+":"+(C.get(Calendar.MINUTE))+":"+C.get(Calendar.SECOND)+" "+C.get(Calendar.AM_PM);
	    out.println("<tr><td><b><i>Current date:</i></b></td>");
	    out.println("<td><input type='text' name='vcdate' value="+cd+"></td></tr>");
	    
	    out.println("<tr><td><b><i>Current time:</i></b></td>");
	    out.println("<td><input type='text' name='vctime' value="+ct+"></td></tr>");
	    
	    out.println("<tr><td><b><i>Amount:</i></b></td>");
	    out.println("<td><input type='text' name='vamt' value='30'></td></tr>");
	    
	    out.println("<tr><td><b><i>Time:</i></b></td>");
	    out.println("<td><select name='vtime'><option value='1'>1</option><option value='2'>2</option><option selected value='3'>3</option><option value='4'>4</option></select></td></tr>");
	    
	    out.println("<tr><td><b><i>Status:</i></b></td>");
	    out.println("<td><select name='vstatus'><option selected value='in'>in</option><option value='out'>out</option></select>");
	    
	    out.println("<tr><td valign='top'><b><i>Floor No:</i></b></td>");
	    out.println("<td><select name='vfno' id='vfno'></select><br><div id='fdiv'></div></td></tr>");
	    
	    out.println("</table><br><br>");
	    out.println("<input type='submit'>  <input type='Reset'></form></table>");
	    
	    
	    
	    out.flush();
	}

}
