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

@WebServlet("/deleteVehicle")
public class DeleteVehicle extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		
		VehicleDao dao = new VehicleDao(DBConnect.getConn());
		HttpSession session = req.getSession();
		
		if(dao.deleteVehicle(id))
		{
			session.setAttribute("succMsg", "Vehicle Delete Sucessfully..");
			resp.sendRedirect("admin/view_vehicle.jsp");
		}else {
			session.setAttribute("errorMsg", "something wrong on server");
			resp.sendRedirect("admin/view_vehicle.jsp");
			
		}
	}

	

}
