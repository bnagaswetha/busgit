package org.cap.service;

import java.time.LocalDate;
import java.util.List;

import org.cap.bean.BusBean;
import org.cap.bean.RouteMapBean;
import org.cap.bean.TransactionBean;

public interface IBusRouteService {
	public RouteMapBean addBusRoute(RouteMapBean routeBean);
	public List<BusBean> pendingDetails();
	public abstract List<BusBean> pendingDetailsOfEmp(String empid);
	public abstract Integer transaction(TransactionBean transaction);
	public List<TransactionBean> monthlyReport(LocalDate fdate,LocalDate tdate);
}
