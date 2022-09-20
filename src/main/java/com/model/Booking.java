package com.model;

public class Booking {

    private int id;
    private int userId;
    private String fullName;
    private String bookinDate;
    private String email;
    private String phNo;
    private int driverId;
    private int vehicleId;
    private String address;
    private String status;
    
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(int userId, String fullName, String bookinDate, String email, String phNo, int driverId,
			int vehicleId, String address, String status) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.bookinDate = bookinDate;
		this.email = email;
		this.phNo = phNo;
		this.driverId = driverId;
		this.vehicleId = vehicleId;
		this.address = address;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getBookinDate() {
		return bookinDate;
	}
	public void setBookinDate(String bookinDate) {
		this.bookinDate = bookinDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
	
    
    
    
    

}
