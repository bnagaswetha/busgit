package org.cap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.cap.bean.BusBean;
import org.cap.bean.RouteMapBean;

public class BusRouteImpl implements IBusRoute {

	@Override
	public RouteMapBean addBusRoute(RouteMapBean routeBean) {
		String sql="insert into routemap(routepath,occseats,totalseats,busno,busdriver,totalkm) values(?,?,?,?,?,?)";
		int routeCount=0;
		try(

				PreparedStatement ps=getConnection().prepareStatement(sql);

				){
			ps.setString(1, routeBean.getRoutepath());
			ps.setInt(2, routeBean.getOccseats());
			ps.setInt(3, routeBean.getTotalseats());
			ps.setInt(4, routeBean.getBusno());
			ps.setString(5, routeBean.getBusdriver());
			ps.setInt(6, routeBean.getTotalkm());
			int n=ps.executeUpdate();

			if(n>0){
				return routeBean;
			}else{
				return null;
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;

		
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
	public List<BusBean> pendingRequests() {
		String sql="select * from buspassrequest where status='Pending'";
		int pCount=0;
		try(

				Statement ps=getConnection().createStatement();

				){
			ResultSet rs=ps.executeQuery(sql);
			List<BusBean> pList=new ArrayList<>();
			while(rs.next()){
				
				pCount++;
				BusBean busBean=new BusBean();
				
				
				
			}
			if(pCount>0){
				return pList;
			}else{
				return null;
			}
			

		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

}
