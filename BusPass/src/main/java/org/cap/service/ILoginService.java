package org.cap.service;

import java.util.List;

import org.cap.bean.BusBean;
import org.cap.bean.LoginBean;
import org.cap.bean.RouteMapBean;

public interface ILoginService {
	public boolean isValidLogin(LoginBean loginBean);
	public BusBean createRequest(BusBean busBean);
	public List<RouteMapBean> getAllRoutes();

}
