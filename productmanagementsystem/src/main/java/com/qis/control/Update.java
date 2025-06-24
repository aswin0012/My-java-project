package com.qis.control;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import productmanagementsystem.entity.Product;
@WebServlet("/Update")
public  class Update extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id")) ;
		String pname = req.getParameter("pname");
		int price = Integer.parseInt(req.getParameter("price"));
	
		
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.print("<form action='save' method='post'>"+
		"<label>id</lable>"+
				"<input type='number' name='id' value='"+id+"'>"
				+"<lable>Product</lable>"+
				"<input type=\"text\" name='pname' value='"+pname+"'>"+
				"<label>Price</label>\r\n"
				+ "<input type=\"number\" name='price' value='"+price+"'>"
				+ "<input type=\"submit\">"
				+ "</form>" );
		   
	}

}
