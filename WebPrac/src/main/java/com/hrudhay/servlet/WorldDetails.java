package com.hrudhay.servlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
		String file = request.getParameter("File");
		WorldDao wod = new WorldDao();
		try {
			World wo = wod.getWorld(id);
			if(file.contains("yes")) {
				CreateFile(wo);
			}
			request.setAttribute("idCountry", wo);
			RequestDispatcher rd = request.getRequestDispatcher("showWorldDetails.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	void CreateFile(World wo) throws IOException {
		File file = new File("D:\\EE WorkSpacee\\test write files\\World.txt");
		FileWriter fw = new FileWriter(file);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(wo.getID()+" "+wo.getName()+" "+wo.getCountryCode()+" "+wo.getDistrict()+" "+wo.getPopulation()+"\n");
		pw.close();
	}
	
}
