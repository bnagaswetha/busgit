package org.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cap.bean.BusBean;
import org.cap.service.BusRouteService;
import org.cap.service.IBusRouteService;


@WebServlet("/Pending")
public class Pending extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBusRouteService busservice=new BusRouteService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		List<BusBean> pendingList=busservice.pendingDetails();


		PrintWriter pw=response.getWriter();
		

		pw.println("<html><body><h3 align='center'>All Pending Requests</h3>");
		pw.println("<table>"
				+ "<tr>"
				
			
				+ "</tr>");

		for(BusBean emp:pendingList) {
			
			pw.println("<form action='ListAllPendingRequestsServlet' method='post'>"
					+ "<p>"+emp.getEmployee_id()+"</p>"
					+"<input type='hidden' value="+emp.getEmployee_id()+" name='empid'>"
					+"<input type='submit' value='View' name='view'>"
					+"</form>"
					
					);
		}

		pw.println("</table></body></html>");

		
		
	}

}
