package org.cap.dao;

import java.util.List;

import org.cap.bean.BusBean;
import org.cap.bean.RouteMapBean;

public interface IBusRoute {
	public RouteMapBean addBusRoute(RouteMapBean routeBean);
	public List<BusBean> pendingRequests();

}
