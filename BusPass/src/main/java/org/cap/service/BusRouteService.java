package org.cap.service;

import java.time.LocalDate;
import java.util.List;

import org.cap.bean.BusBean;
import org.cap.bean.RouteMapBean;
import org.cap.bean.TransactionBean;
import org.cap.dao.BusRouteImpl;
import org.cap.dao.IBusRoute;
import org.cap.dao.IPending;
import org.cap.dao.PendingImpl;

public class BusRouteService implements IBusRouteService{
	private IBusRoute busRoute=new BusRouteImpl();
	private IPending pending=new PendingImpl();

	@Override
	public RouteMapBean addBusRoute(RouteMapBean routeBean) {
		if(busRoute.addBusRoute(routeBean) != null)
			return routeBean;
		return null;

	}

	@Override
	public List<BusBean> pendingDetails() {
		List<BusBean> pendingList=pending.pendingDetails();
		if(pendingList!=null)
			return pendingList;
		
		return null;
	}

	@Override
	public List<BusBean> pendingDetailsOfEmp(String empid) {
		List<BusBean> pendingList=pending.pendingDetailsOfEmp(empid);
		if(pendingList!=null)
			return pendingList;
		return null;
	}

	@Override
	public Integer transaction(TransactionBean transaction) {
		Integer transaction_id=pending.transaction(transaction);
		return transaction_id;
	}

	@Override
	public List<TransactionBean> monthlyReport(LocalDate fdate, LocalDate tdate) {
		List<TransactionBean> tBean=pending.monthlyReport(fdate, tdate);
		if(tBean!=null)
			return tBean;
		return null;
	}

}
