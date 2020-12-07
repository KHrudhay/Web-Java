package com.hrudhay.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrudhay.web.dao.WorldDao;
import com.hrudhay.web.model.World;

/**
 * Servlet implementation class IndiaDetails
 */
public class WorldDetails extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");
		WorldDao wod = new WorldDao();
		try {
			World wo = wod.getWorld(id);
			request.setAttribute("idCountry", wo);
			RequestDispatcher rd = request.getRequestDispatcher("showWorldDetails.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
