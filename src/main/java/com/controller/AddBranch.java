package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BranchDao;
import com.dao.DBConnect;
import com.model.User;

@WebServlet("/addBranch")
public class AddBranch extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       String branName=req.getParameter("branName");
	       
	       BranchDao dao = new BranchDao (DBConnect.getConn());
	       boolean f =  dao.addBranch(branName);
	       
	       HttpSession session = req.getSession();
	       
			if(f)
			{
				session.setAttribute("succMsg", "Branch Added");
				resp.sendRedirect("admin/index.jsp");
			}else {
				session.setAttribute("errorMsg", "something wrong on server");
				resp.sendRedirect("admin/index.jsp");
				
				
			}
	}

	

}

