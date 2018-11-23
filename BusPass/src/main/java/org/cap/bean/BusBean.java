package org.cap.bean;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class BusBean {
	private String employee_id;
	private String firstName;
	private String lastName;
	private String gender;
	private String address;
	private LocalDate dofjoining;
	private String emailId;
	private String location;
	private String pickupLocation;
	private String designation;
	private LocalTime pickupTime;
	
	private String status="Pending";
	private Integer requestId;
	public BusBean() {
		super();
	}
	
	
	
	public BusBean(String employee_id, String firstName, String lastName, String gender, String address,
			LocalDate dofjoining, String emailId, String location, String pickupLocation, String designation,
			LocalTime pickupTime, String status, Integer requestId) {
		super();
		this.employee_id = employee_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.address = address;
		this.dofjoining = dofjoining;
		this.emailId = emailId;
		this.location = location;
		this.pickupLocation = pickupLocation;
		this.designation = designation;
		this.pickupTime = pickupTime;
		this.status = status;
		this.requestId = requestId;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getDofjoining() {
		return dofjoining;
	}
	public void setDofjoining(LocalDate dofjoining) {
		this.dofjoining = dofjoining;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPickupLocation() {
		return pickupLocation;
	}
	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}
	public LocalTime getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(LocalTime pickupTime) {
		this.pickupTime = pickupTime;
	}
	public Integer getRequestId() {
		return requestId;
	}
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}



	@Override
	public String toString() {
		return "BusBean [employee_id=" + employee_id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", address=" + address + ", dofjoining=" + dofjoining + ", emailId=" + emailId
				+ ", location=" + location + ", pickupLocation=" + pickupLocation + ", designation=" + designation
				+ ", pickupTime=" + pickupTime + ", status=" + status + ", requestId=" + requestId + "]";
	}
	
	

}
