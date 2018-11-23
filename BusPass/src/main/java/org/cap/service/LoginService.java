package org.cap.service;

import java.util.ArrayList;
import java.util.List;

import org.cap.bean.BusBean;
import org.cap.bean.LoginBean;
import org.cap.bean.RouteMapBean;
import org.cap.dao.ILoginDao;
import org.cap.dao.LoginDaoImpl;


public class LoginService implements ILoginService{
	private ILoginDao loginDao;
	public LoginService() {
		this.loginDao=new LoginDaoImpl();
	}

	@Override
	public boolean isValidLogin(LoginBean loginBean) {
		if(loginDao.isValidLogin(loginBean))
			return true;
		return false;
	}

	@Override
	public BusBean createRequest(BusBean busBean) {
		if(loginDao.createRequest(busBean) != null)
			return busBean;
		return null;
	}

	@Override
	public List<RouteMapBean> getAllRoutes() {
		List<RouteMapBean> routeList=loginDao.getAllRoutes();
		return routeList;
	}

}
