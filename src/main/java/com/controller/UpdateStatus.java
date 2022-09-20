package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BookingDao;
import com.dao.DBConnect;

@WebServlet("/updateStatus")
public class UpdateStatus extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			int vid=Integer.parseInt(req.getParameter("vid"));
			String comm=req.getParameter("comm");
			
			BookingDao dao = new BookingDao(DBConnect.getConn());
			
			HttpSession session =req.getSession();
			
			if(dao.updateCommentStatus(id, vid, comm))
			{  session.setAttribute("succMsg", "Comment Updated");
			   resp.sendRedirect("vehicle/customer.jsp");
				
			}else {
				session.setAttribute("errorMsg", "Somthing wrong on server");
				resp.sendRedirect("vehicle/customer.jsp");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
