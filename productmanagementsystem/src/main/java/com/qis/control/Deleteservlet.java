package com.qis.control;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import productmanagementsystem.entity.Product;
@WebServlet("/delete")
public class Deleteservlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String pname = req.getParameter("pname");
		int price = Integer.parseInt(req.getParameter("price"));
		
		Product delete=new Product();
		delete.setpId(id);
		delete.setpName(pname);
		delete.setPrice(price);
		
		Configuration c=new  Configuration().addAnnotatedClass(Deleteservlet.class).addAnnotatedClass(Product.class).configure();
		 Session s= c.buildSessionFactory().openSession();
		 Transaction transaction = s.beginTransaction();
		 s.delete(delete);
		 transaction.commit();
		 s.close();
		 
		 resp.setContentType("text/html");
		 PrintWriter writer = resp.getWriter();
		 writer.print("Deleted");
		 
		
	}
	
	
	

}
