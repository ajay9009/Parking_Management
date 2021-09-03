package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FloorView
 */
@WebServlet("/FloorView")
public class FloorView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FloorView() {
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
		out.println("<form action='FloorSubmit' method='post'>");
		out.println("<table>");
	    out.println("<caption><b><i>Floor Register</i></b></caption>");
	    
	    out.println("<tr><td><b><i>Floor Id:</i></b></td>");
	    out.println("<td><input type='text' name='fid'></td></tr>");
	    
	    out.println("<tr><td><b><i>Floor Name:</i></b></td>");
	    out.println("<td><input type='text' name='fn'></td></tr>");
	    
	    out.println("<tr><td><b><i>Number of space:</i></b></td>");
	    out.println("<td><input type='number' name='fnos'></td></tr>");
	    
	    out.println("</table><br><br>");
	    out.println("<input type='submit'>  <input type='Reset'></form></table>");
	    
	    out.flush();
	}


}
