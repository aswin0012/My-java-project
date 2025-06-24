package com.qis.control;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import productmanagementsystem.entity.Product;
@WebServlet("/Delete")
public class Delete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String pname = req.getParameter("pname");
		int price = Integer.parseInt(req.getParameter("price"));
		Product p3=new Product();
		p3.setpId(id);
		p3.setpName(pname);
		p3.setPrice(price);
		
		
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.print("<form action='delete' method='post'>"
				+ "	<label>id</lable>"
				+ "	<input type='number' name='id' value='"+id+"'>"
				+ "	<lable>Product</lable>"
				+ "	<input type='text' name='pname' value='"+pname+"'>"
				+ "				<label>Price</label>"
				+ "				<input type='number' name='price' value='"+price+"'>"
				+ "				<input type='submit'>" );
		
	}
	
	

}
