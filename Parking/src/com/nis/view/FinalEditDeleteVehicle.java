package com.nis.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.VehiclesController;
import com.nis.model.Vehicles;

/**
 * Servlet implementation class FinalEditDeleteVehicle
 */
@WebServlet("/FinalEditDeleteVehicle")
public class FinalEditDeleteVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalEditDeleteVehicle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String vid=request.getParameter("vid");
		String btn=request.getParameter("btn");
		if(btn.equals("Delete"))
		{
			boolean st=VehiclesController.deleteRecord(Integer.parseInt(vid));
			response.sendRedirect("DisplayAllVehicles");
		}
		else if(btn.equals("Edit"))
		{
			Vehicles V=new Vehicles();
			V.setEmployeeid(request.getParameter("eid"));
			V.setVehicleid(request.getParameter("vid"));
			V.setRefernceid(request.getParameter("vrfid"));
			V.setMobileno(request.getParameter("vmob"));
			V.setCurrentdate(request.getParameter("vcdate"));
			V.setCurrenttime(request.getParameter("vctime"));
			V.setAmount(request.getParameter("vamt"));
			V.setTime(request.getParameter("vtime"));
			V.setStatus(request.getParameter("vstatus"));
			V.setFloorno(request.getParameter("vfno"));
			boolean st=VehiclesController.editRecord(V);
			response.sendRedirect("DisplayAllVehicles");
		}
	}

}
