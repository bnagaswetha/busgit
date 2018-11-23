package org.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.bean.RouteMapBean;
import org.cap.service.ILoginService;
import org.cap.service.LoginService;


@WebServlet("/RoutesServlet")
public class RoutesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ILoginService loginService=new LoginService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		List<RouteMapBean> routeList=loginService.getAllRoutes();


		PrintWriter pw=response.getWriter();

		pw.println("<html><body><h3>all routes</h3>");
		pw.println("<table>"
				+ "<tr>"
				+ "<th>Route Id</th>"
				+ "<th>Route</th>"
				+"<th>OccupiedSeats</th>"
				+ "<th>TotalSeats</th>"
				+ "<th>BusNo</th>"
				+ "<th>BusDriver</th>"
				+ "<th>TotalKm</th>"
				+ "</tr>");

		for(RouteMapBean route:routeList) {
			pw.println("<tr>"
					+ "<td>"+route.getRouteid()+"</td>"
					+ "<td>"+route.getRoutepath()+"</td>"
					+ "<td>"+route.getOccseats()+"</td>"
					+ "<td>"+route.getTotalseats()+"</td>"
					+ "<td>"+route.getBusno()+"</td>"
					+ "<td>"+route.getBusdriver()+"</td>"
					+ "<td>"+route.getTotalkm()+"</td>"
					);
		}

		pw.println("</table></body></html>");

	}

}
