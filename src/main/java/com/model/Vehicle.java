package com.model;

public class Vehicle {

	
	private int id;
	private String vehicleName;
	private String vehicleNumber;
	private String driverName;
	private String branch;
	private String email;
	private String mobNo;
	private String password;

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Vehicle(String vehicleName, String vehicleNumber, String driverName, String branch, String email,
			String mobNo, String password) {
		super();
		this.vehicleName = vehicleName;
		this.vehicleNumber = vehicleNumber;
		this.driverName = driverName;
		this.branch = branch;
		this.email = email;
		this.mobNo = mobNo;
		this.password = password;
	}

	

	public Vehicle(int id, String vehicleName, String vehicleNumber, String driverName, String branch, String email,
			String mobNo, String password) {
		super();
		this.id = id;
		this.vehicleName = vehicleName;
		this.vehicleNumber = vehicleNumber;
		this.driverName = driverName;
		this.branch = branch;
		this.email = email;
		this.mobNo = mobNo;
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getVehicleName() {
		return vehicleName;
	}


	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}


	public String getVehicleNumber() {
		return vehicleNumber;
	}


	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}


	public String getDriverName() {
		return driverName;
	}


	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobNo() {
		return mobNo;
	}


	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	

	
}
