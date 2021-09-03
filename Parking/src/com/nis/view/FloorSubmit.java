package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.controller.FloorsController;
import com.nis.model.Floors;

/**
 * Servlet implementation class FloorSubmit
 */
@WebServlet("/FloorSubmit")
public class FloorSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FloorSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Floors F=new Floors();
		F.setFloorid(request.getParameter("fid"));
		F.setFloorname(request.getParameter("fn"));
		F.setNumberofspace(request.getParameter("fnos"));
		boolean status=FloorsController.addNewRecord(F);
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
