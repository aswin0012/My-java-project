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
@WebServlet("/save")
public class Updateservlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String pname = req.getParameter("pname");
		int price = Integer.parseInt(req.getParameter("price"));
		Product update=new Product();
		update.setpId(id);
		update.setpName(pname);
		update.setPrice(price);
		
		Configuration cf=new Configuration().addAnnotatedClass(Updateservlet.class).addAnnotatedClass(Product.class).configure();
		Session session = cf.buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.merge(update);
		transaction.commit();
	     session.close();
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.print("Updated");

	}

}
