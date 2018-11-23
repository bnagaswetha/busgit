package org.cap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.cap.bean.BusBean;
import org.cap.bean.LoginBean;
import org.cap.bean.RouteMapBean;



public class LoginDaoImpl implements ILoginDao{

	@Override
	public boolean isValidLogin(LoginBean loginBean) {
		String sql="select * from userlogin where uname=? and password=?";
		try(PreparedStatement ps=getConnection().prepareStatement(sql)){
			ps.setString(1,loginBean.getUserName());
			ps.setString(2,loginBean.getPassword());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	private Connection getConnection() {
		Connection connection=null;
	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/buspassdb","root","India123");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
		
	}
	@Override
	public BusBean createRequest(BusBean busBean) {
		String sql="insert into busPassrequest(employeeid,firstname,lastname,gender,address,emailid,dateofjoining,location,"
				+ "pickuplocation,pickuptime,status,designation) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try(PreparedStatement pst = getConnection().prepareStatement(sql);){
			pst.setString(1, busBean.getEmployee_id());
			pst.setString(2, busBean.getFirstName());
			pst.setString(3, busBean.getLastName());
			pst.setString(4, busBean.getGender());
			pst.setString(5, busBean.getAddress());
			pst.setString(6, busBean.getEmailId());
			pst.setDate(7, Date.valueOf(busBean.getDofjoining()));
			pst.setString(8, busBean.getLocation());
			pst.setString(9, busBean.getPickupLocation());
			pst.setTime(10, Time.valueOf(busBean.getPickupTime()));
			pst.setString(11, busBean.getStatus());
			pst.setString(12, busBean.getDesignation());
			
			
			int count=pst.executeUpdate();
			if(count>0) {
				return busBean;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<RouteMapBean> getAllRoutes() {
		String sql="select * from routemap";
		int routeCount=0;
		try(
				
				Statement statement=getConnection().createStatement();

				){
			ResultSet resultSet=statement.executeQuery(sql);
			List<RouteMapBean> routeList=new ArrayList<>();
			while(resultSet.next()){
				routeCount++;
				RouteMapBean route=new RouteMapBean();
				populateRoute(route,resultSet);

				routeList.add(route);
				
			}
			if(routeCount>0){
				return routeList;
			}else{
				return null;
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	private void populateRoute(RouteMapBean route, ResultSet resultSet) throws SQLException {
		route.setRouteid(resultSet.getInt(1));
		route.setRoutepath(resultSet.getString(2));
		route.setOccseats(resultSet.getInt(3));
		route.setTotalseats(resultSet.getInt(4));
		route.setBusno(resultSet.getInt(5));
		route.setBusdriver(resultSet.getString(6));
		route.setTotalkm(resultSet.getInt(7));
		
	}

}
