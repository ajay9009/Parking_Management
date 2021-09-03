package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.nis.controller.EmployeesController;
import com.nis.model.Employees;

/**
 * Servlet implementation class CheckEmployeesLogin
 */
@WebServlet("/CheckEmployeesLogin")
public class CheckEmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckEmployeeLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html>");
		int id=Integer.parseInt(request.getParameter("id"));
		String password=request.getParameter("password");
		
		
		Employees E=EmployeesController.checkLogin(id, password);
		if(E!=null)
		{
			HttpSession ses=request.getSession();
			ses.putValue("EMPLOYEEID",E.getEmployeeid());
			ses.putValue("EMPLOYEENAME",E.getEmployeename());
			ses.putValue("EMPLOYEEPICTURE",E.getPicture());
			ses.putValue("LTIME",new Date());
		response.sendRedirect("EmployeeHome");	
		}
		else
		{
		out.println("<b><font color='red'>Invalid EmployeeId/Password</font></b>");	
		}
		
		out.println("</html>");
	}

}
