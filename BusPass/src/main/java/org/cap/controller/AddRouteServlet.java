package org.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.bean.RouteMapBean;
import org.cap.service.BusRouteService;
import org.cap.service.IBusRouteService;
import org.cap.service.ILoginService;
import org.cap.service.LoginService;


@WebServlet("/AddRouteServlet")
public class AddRouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBusRouteService loginService=new BusRouteService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		String routepath = request.getParameter("routepath");
		String occseats = request.getParameter("occupiedseats");
		String totalseats = request.getParameter("totalseats");
		String busno=request.getParameter("busno");
		String drivername = request.getParameter("drivername");
		String totalkm = request.getParameter("totalkm");

		RouteMapBean routeBean = new RouteMapBean();
		routeBean.setRoutepath(routepath);
		routeBean.setOccseats((Integer.parseInt(occseats)));
		routeBean.setTotalseats((Integer.parseInt(totalseats)));
		routeBean.setBusno(Integer.parseInt((busno)));
		routeBean.setBusdriver((drivername));
		routeBean.setTotalkm(Integer.parseInt(totalkm));
		

		if(loginService.addBusRoute(routeBean)!= null) {
			response.sendRedirect("pages/RouteSuccess.html");
		}else {


			PrintWriter pw=response.getWriter();
			pw.println("<h1>Unable to Add new route</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("pages/addRoute.html");
			rd.include(request, response);
		}
	}



}


