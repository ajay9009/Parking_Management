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
 * Servlet implementation class VehiclesSubmit
 */
@WebServlet("/VehiclesSubmit")
public class VehiclesSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehiclesSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Vehicles V=new Vehicles();
		V.setEmployeeid(request.getParameter("eid"));
		V.setRefernceid(request.getParameter("vrfid"));
		V.setMobileno(request.getParameter("vmob"));
		V.setCurrentdate(request.getParameter("vcdate"));
		V.setCurrenttime(request.getParameter("vctime"));
		V.setAmount(request.getParameter("vamt"));
		V.setTime(request.getParameter("vtime"));
		V.setStatus(request.getParameter("vstatus"));
		V.setFloorno(request.getParameter("vfno"));
		V.setRegistrationno(request.getParameter("regno"));
		boolean status=VehiclesController.addNewRecord(V);
		out.println("<html>");
		if(status)
		{
		out.println("Record Submitted...");	
		}
		else{
		out.println("Fail to Submit Employee Record...");	
			
		}
		out.println("</html>");
		out.flush();
	}

}
