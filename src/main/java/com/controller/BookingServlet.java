package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BookingDao;
import com.dao.DBConnect;
import com.model.Booking;

@WebServlet ("/appBooking")
public class BookingServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int userId = Integer.parseInt(req.getParameter("userid"));
		String fullname = req.getParameter("fullname");
		String booking_date = req.getParameter("booking_date");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		int driver_id = Integer.parseInt(req.getParameter("driver_id"));
		int vehicle_id = Integer.parseInt(req.getParameter("vehicle_id"));
	
		String address = req.getParameter("address");
			
		Booking ap= new Booking(userId, fullname, booking_date, email, phno, driver_id, vehicle_id, address,"Pending");
		
		BookingDao dao = new BookingDao(DBConnect.getConn());
		HttpSession session = req.getSession();
		
		if(dao.addBooking(ap)) {
		   session.setAttribute("succMsg", "Booking Sucessfully");
			resp.sendRedirect("user_booking.jsp");
		}else {
			session.setAttribute("succMsg", "Something wrong on server");
			resp.sendRedirect("user_booking.jsp");
		}
	}
	
	
	

   	

}
