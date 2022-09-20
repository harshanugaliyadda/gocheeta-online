package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DBConnect;
import com.dao.VehicleDao;
import com.model.Vehicle;

@WebServlet("/addVehicle")
public class AddVehicle extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			
			String vehicleName = req.getParameter("vehiclename");
			String vehicleNumber = req.getParameter("vehiclenumber");
			String driverName = req.getParameter("drivername");
			String bran = req.getParameter("bran");
			String email = req.getParameter("email");
			String mobno = req.getParameter("mobno");
			String password = req.getParameter("password");
			
			Vehicle d = new Vehicle(vehicleName, vehicleNumber, driverName, bran, email, mobno, password);
			
			VehicleDao dao = new VehicleDao(DBConnect.getConn());
			HttpSession session = req.getSession();
			
			if(dao.registerVehicle(d))
			{
				session.setAttribute("succMsg", "Vehicle Added Sucessfully..");
				resp.sendRedirect("admin/vehicle.jsp");
			}else {
				session.setAttribute("errorMsg", "something wrong on server");
				resp.sendRedirect("admin/vehicle.jsp");
				
			}
				
				
				
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
