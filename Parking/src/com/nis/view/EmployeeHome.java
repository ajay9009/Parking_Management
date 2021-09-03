package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeesHome
 */
@WebServlet("/EmployeeHome")
public class EmployeeHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeHome() {
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
		HttpSession ses=request.getSession();
		try{
		String nv="Employee Id:"+ses.getValue("EMPLOYEEID").toString()+"&nbsp;&nbsp;&nbsp;"+ses.getValue("EMPLOYEENAME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src='/Parking/images/"+ses.getValue("EMPLOYEEPICTURE")+"' width=30 height=30><hr color=red>";
		out.println(nv);
		out.println("<table>");
		out.println("<tr><td valign='top'>");
		out.println("<a href='VehicleView' target='ew'>Add Vehicle</a><br>");
		out.println("<a href='DisplayAllVehicles' target='ew'>Display Vehicle</a><br>");	
		out.println("<a href='SearchVehicleById' target='ew'>Search Vehicle</a><br>");
		out.println("<a href='DisplayVehicleByRFID' target='ew'>Exit Vehicle</a><br>");
		out.println("<a href='EmployeeLogin'>Logout</a><br>");
		out.println("<td valign='top'><iframe frameborder='0' width='900' height='700' name='ew'></iframe></td></tr>");
		out.println("</table>");
		}catch(Exception e)
		{
			response.sendRedirect("EmployeeLogin");
		}
		out.println("</html>");
	}
	

	

}
