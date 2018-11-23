package org.cap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.cap.bean.BusBean;
import org.cap.bean.TransactionBean;

public class PendingImpl implements IPending{

	@Override
	public List<BusBean> pendingDetails() {
		
		String sql="select * from buspassrequest where status='Pending'";
		int pendingCount=0;
		try(
				
				Statement statement=getConnection().createStatement();

				){
			ResultSet resultSet=statement.executeQuery(sql);
			List<BusBean> pendingList=new ArrayList<>();
			while(resultSet.next()){
				pendingCount++;
				BusBean busBean=new BusBean();
				populateRoute(busBean,resultSet);

				pendingList.add(busBean);
				
			}
			if(pendingCount>0){
				return pendingList;
			}else{
				return null;
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	private void populateRoute(BusBean bus, ResultSet rs) throws SQLException {
		bus.setEmployee_id(rs.getString("employeeId"));
		bus.setFirstName(rs.getString("firstname"));
		bus.setLastName(rs.getString("lastname"));
		bus.setGender(rs.getString("gender"));
		bus.setAddress(rs.getString("address"));
		bus.setEmailId(rs.getString("emailid"));
		java.sql.Date sqlDate=rs.getDate("dateofjoining");
		 java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
		 Instant instant = Instant.ofEpochMilli(utilDate.getTime()); 
		 LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()); 
		 LocalDate localDate = localDateTime.toLocalDate();
		 bus.setDofjoining(localDate);
		
		bus.setLocation(rs.getString("location"));
		bus.setPickupLocation(rs.getString("pickuplocation"));
		Time time=rs.getTime("pickuptime");
		LocalTime localTime=time.toLocalTime();
		bus.setPickupTime(localTime);
		
		bus.setStatus(rs.getString("status"));
		bus.setDesignation(rs.getString("designation"));
		
		
	
		
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
	public List<BusBean> pendingDetailsOfEmp(String empid) {
		String sql="select * from buspassrequest where employeeId=?";
		int pendingCount=0;
		try(
				
				PreparedStatement preparedStatement=getConnection().prepareStatement(sql);

				){
			preparedStatement.setString(1, empid);
			ResultSet resultSet=preparedStatement.executeQuery();
			List<BusBean> pendingList=new ArrayList<>();
			while(resultSet.next()){
				pendingCount++;
				BusBean busBean=new BusBean();
				populateRoute(busBean,resultSet);

				pendingList.add(busBean);
				
			}
			if(pendingCount>0){
				return pendingList;
			}else{
				return null;
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Integer transaction(TransactionBean transaction) {
		String sql="insert into transaction(employeeId,transaction_date,calculated_km,monthly_fare,route_id) values(?,?,?,?,?)";
		String sql1="update buspassrequest set status=? where employeeId=?";
		String sql2="update routemap set occseats=occseats+1 where routeid=?";
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
				PreparedStatement preparedStatement2 = getConnection().prepareStatement(sql1);
				PreparedStatement preparedStatement1 = getConnection().prepareStatement("select transaction_id from transaction where employeeId=?");
				PreparedStatement preparedStatement3 = getConnection().prepareStatement(sql2);
				){
			preparedStatement.setString(1,transaction.getEmp_id());
			preparedStatement.setDate(2, Date.valueOf(transaction.getTransaction_date()));
			preparedStatement.setDouble(3, transaction.getTotal_km());
			preparedStatement.setInt(4, transaction.getMonthly_fare());
			preparedStatement.setInt(5, transaction.getRoute_id());
			
			preparedStatement1.setString(1,transaction.getEmp_id());
			preparedStatement2.setString(1,"Approved");
			preparedStatement2.setString(2, transaction.getEmp_id());
			
			preparedStatement3.setInt(1,transaction.getRoute_id());
			
			int n=preparedStatement.executeUpdate();
			
			if(n>0) {
				ResultSet resultSet = preparedStatement1.executeQuery();
				if(resultSet.next()) {
					Integer transaction_id = resultSet.getInt(1);
					int n1=preparedStatement2.executeUpdate();
					int n2=preparedStatement3.executeUpdate();
					if(n1>0 && n2>0)
						return transaction_id;
				}
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<TransactionBean> monthlyReport(LocalDate fdate, LocalDate tdate) {
		String sql="select * from transaction where transaction_date between ? and ?";
		int tCount=0;
		try(
				
				PreparedStatement preparedStatement=getConnection().prepareStatement(sql);

				){
			preparedStatement.setDate(1,Date.valueOf(fdate));
			preparedStatement.setDate(2,Date.valueOf(tdate));
			
			ResultSet resultSet=preparedStatement.executeQuery();
			List<TransactionBean> tList=new ArrayList<>();
			while(resultSet.next()){
				tCount++;
				TransactionBean tBean=new TransactionBean();
				tBean.setTransaction_id(resultSet.getInt(1));
				tBean.setEmp_id(resultSet.getString(2));
				java.sql.Date sqlDate=resultSet.getDate("transaction_date");
				 java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
				 Instant instant = Instant.ofEpochMilli(utilDate.getTime()); 
				 LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()); 
				 LocalDate localDate = localDateTime.toLocalDate();
				tBean.setTransaction_date(localDate);
				tBean.setTotal_km(resultSet.getDouble(4));
				tBean.setMonthly_fare(resultSet.getInt(5));
				tBean.setRoute_id(resultSet.getInt(6));
				

				tList.add(tBean);
				
			}
			if(tCount>0){
				return tList;
			}else{
				return null;
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
		
		
	}
	}

