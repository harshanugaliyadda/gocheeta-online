package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Booking;

public class BookingDao {

	private Connection conn;

	public BookingDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addBooking(Booking ap)
	{
		boolean f=false;
		
		try {
			String sql="insert into booking(user_id, fullname, booking_date, email, phno, driver_id, vehicle_id,address, status) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, ap.getUserId());
			ps.setString(2, ap.getFullName());
			ps.setString(3,ap.getBookinDate());
			ps.setString(4,ap.getEmail());
			ps.setString(5,ap.getPhNo());
			ps.setInt(6, ap.getDriverId());
			ps.setInt(7, ap.getVehicleId());		
			ps.setString(8, ap.getAddress());
			ps.setString(9, ap.getStatus());
			
			int i= ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return f;
	}
	
	public List<Booking> getAllBookingByLoginUser(int userId)
	{
		List<Booking> list= new ArrayList<Booking>();
		Booking ap = null;
		
		try {
			String sql = "select * from Booking where user_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ap=new Booking();
				ap.setId(rs.getInt(1));
				ap.setUserId(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setBookinDate(rs.getString(4));
				ap.setEmail(rs.getString(5));
				ap.setPhNo(rs.getString(6));
				ap.setDriverId(rs.getInt(7));
				ap.setVehicleId(rs.getInt(8));
				ap.setAddress(rs.getString(9));
				ap.setStatus(rs.getString(10));
				list.add(ap);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		return list;
	}
	
	public List<Booking> getAllBookingByVehicleLogin(int vehicleId)
	{
		List<Booking> list= new ArrayList<Booking>();
		Booking ap = null;
		
		try {
			String sql = "select * from Booking where vehicle_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, vehicleId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ap=new Booking();
				ap.setId(rs.getInt(1));
				ap.setUserId(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setBookinDate(rs.getString(4));
				ap.setEmail(rs.getString(5));
				ap.setPhNo(rs.getString(6));
				ap.setDriverId(rs.getInt(7));
				ap.setVehicleId(rs.getInt(8));
				ap.setAddress(rs.getString(9));
				ap.setStatus(rs.getString(10));
				list.add(ap);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		return list;
	}
	
	public Booking getBookingById(int Id)
	{
		
		Booking ap = null;
		
		try {
			String sql = "select * from Booking where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ap=new Booking();
				ap.setId(rs.getInt(1));
				ap.setUserId(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setBookinDate(rs.getString(4));
				ap.setEmail(rs.getString(5));
				ap.setPhNo(rs.getString(6));
				ap.setDriverId(rs.getInt(7));
				ap.setVehicleId(rs.getInt(8));
				ap.setAddress(rs.getString(9));
				ap.setStatus(rs.getString(10));
				
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		return ap;
	}
	
	public boolean updateCommentStatus(int id,int vehiId, String comm)
	{
		Boolean f = false;
		try {
			String sql ="update booking set status=? where id=? and vehicle_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, comm);
			ps.setInt(2, id);
			ps.setInt(3, vehiId);
			
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	public List<Booking> getAllBooking() {
		List<Booking> list = new ArrayList<Booking>();
		Booking ap = null;

		try {

			String sql = "select * from booking order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Booking();
				ap.setId(rs.getInt(1));
				ap.setUserId(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setBookinDate(rs.getString(4));
				ap.setEmail(rs.getString(5));
				ap.setPhNo(rs.getString(6));
				ap.setDriverId(rs.getInt(7));
				ap.setVehicleId(rs.getInt(8));
				ap.setAddress(rs.getString(9));
				ap.setStatus(rs.getString(10));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
