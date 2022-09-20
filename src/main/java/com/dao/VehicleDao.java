package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Vehicle;

public class VehicleDao {
    private Connection conn;

	public VehicleDao(Connection conn) {
		super();
		this.conn = conn;
	}
    
    public boolean registerVehicle (Vehicle d)

    {
    	boolean f=false;
    	
    	try {
    		String sql="insert into vehicle(vehicle_name,vehicle_number,driver_name,branch,email,mobno,password) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, d.getVehicleName());
			ps.setString(2, d.getVehicleNumber());
			ps.setString(3, d.getDriverName());
			ps.setString(4, d.getBranch());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobNo());
			ps.setString(7, d.getPassword());
			
			int i =ps.executeUpdate();
			if (i==1) {
				f=true;
			}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
		return f;
    	
    }
    
    public List<Vehicle> getAllVehicle()
    {
    	List<Vehicle> list=new ArrayList<Vehicle>();
    	Vehicle d =null;
    	 
    	try {
    		
    		String sql="select * from Vehicle order by id desc";
    		PreparedStatement ps=conn.prepareStatement(sql);
    		
    		ResultSet rs=ps.executeQuery();
    		while(rs.next())
    		{
    			d=new Vehicle();
    			d.setId(rs.getInt(1));
    			d.setVehicleName(rs.getString(2));
    			d.setVehicleNumber(rs.getNString(3));
    			d.setDriverName(rs.getString(4));
    			d.setBranch(rs.getNString(5));
    			d.setEmail(rs.getString(6));
    			d.setMobNo(rs.getString(7));
    			d.setPassword(rs.getString(8));
    			list.add(d);
    			
    			
    		}
    		
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return list;
    }
    
    
    public Vehicle getVehicleById(int id)
    {
    	
    	Vehicle d =null;
    	 
    	try {
    		
    		String sql="select * from Vehicle where id=?";
    		PreparedStatement ps=conn.prepareStatement(sql);
    		ps.setInt(1, id);
    		
    		ResultSet rs=ps.executeQuery();
    		
    		while(rs.next())
    		{
    			d=new Vehicle();
    			d.setId(rs.getInt(1));
    			d.setVehicleName(rs.getString(2));
    			d.setVehicleNumber(rs.getNString(3));
    			d.setDriverName(rs.getString(4));
    			d.setBranch(rs.getNString(5));
    			d.setEmail(rs.getString(6));
    			d.setMobNo(rs.getString(7));
    			d.setPassword(rs.getString(8));
    			
    			
    			
    		}
    		
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return d;
    }
    
    
    public boolean updateVehicle (Vehicle d)

    {
    	boolean f=false;
    	
    	try {
    		String sql="update vehicle set vehicle_name=?,vehicle_number=?,driver_name=?,branch=?,email=?,mobno=?,password=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, d.getVehicleName());
			ps.setString(2, d.getVehicleNumber());
			ps.setString(3, d.getDriverName());
			ps.setString(4, d.getBranch());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobNo());
			ps.setString(7, d.getPassword());
			ps.setInt(8, d.getId());
			
			int i =ps.executeUpdate();
			
			if (i==1) {
				f=true;
			}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
		return f;
    	
    }
    
    public boolean deleteVehicle(int id)
    {
    	boolean f = false;
    	try {
    		String sql = "delete from vehicle where id=?";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setInt(1, id);
    		
    		int i = ps.executeUpdate();
    		if(i == 1);
    		{
    			f = true; 
    		}
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
    	
    	return f;
    	
    }
    
    public  Vehicle Login(String email, String psw)
    {
    	Vehicle d=null;
    	try {
    		String sql="select * from vehicle where email=? and password=?";
    		PreparedStatement ps=conn.prepareStatement(sql);
    		ps.setString(1, email);
    		ps.setString(2, psw);
    		
    		ResultSet rs = ps.executeQuery();
    		while(rs.next()) {
               
    			d=new Vehicle();
    			d=new Vehicle();
    			d.setId(rs.getInt(1));
    			d.setVehicleName(rs.getString(2));
    			d.setVehicleNumber(rs.getString(3));
    			d.setDriverName(rs.getString(4));
    			d.setBranch(rs.getString(5));
    			d.setEmail(rs.getString(6));
    			d.setMobNo(rs.getString(7));
    			d.setPassword(rs.getString(8));
    		}
    		
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    
     
    return d;
   
    }
    
    public int countVehicle() {
    	int i = 0;
    	
    	try {
    		String sql="select * from vehicle";
    		PreparedStatement ps =conn.prepareStatement(sql);
    		ResultSet rs = ps.executeQuery();
    		while(rs.next())
    		{
    			i++;
    		}
    		
			
		} catch (Exception e) {
			  e.printStackTrace();
		}
    	return i;
    }
    
    public int countBranch() {
    	int i = 0;
    	
    	try {
    		String sql="select * from branch";
    		PreparedStatement ps =conn.prepareStatement(sql);
    		ResultSet rs = ps.executeQuery();
    		while(rs.next())
    		{
    			i++;
    		}
    		
			
		} catch (Exception e) {
			  e.printStackTrace();
		}
    	return i;
    }
    
    public int countBooking() {
    	int i = 0;
    	
    	try {
    		String sql="select * from booking";
    		PreparedStatement ps =conn.prepareStatement(sql);
    		ResultSet rs = ps.executeQuery();
    		while(rs.next())
    		{
    			i++;
    		}
    		
			
		} catch (Exception e) {
			  e.printStackTrace();
		}
    	return i;
    }
   
    
    
    }


