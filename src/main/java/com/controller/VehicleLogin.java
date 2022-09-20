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

@WebServlet ("/vehicleLogin")
public class VehicleLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email= req.getParameter("email");
		String password= req.getParameter("password");
		
		HttpSession session=req.getSession();
		
		VehicleDao dao = new VehicleDao(DBConnect.getConn());
		Vehicle vehicle = dao.Login(email, password);
		
		if(vehicle != null)
		{
			session.setAttribute("vehiObj", vehicle);
			resp.sendRedirect("vehicle/index.jsp");
		}else {
			session.setAttribute("errorMsg", "invalid email & password");
			resp.sendRedirect("driver_login.jsp");
			
			
		}
		
		
		
		
		
	}

	

}
