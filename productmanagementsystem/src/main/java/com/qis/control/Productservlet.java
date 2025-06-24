package com.qis.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import productmanagementsystem.entity.Product;

@WebServlet("/project")
public class Productservlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pname = req.getParameter("pname");
		int price = Integer.parseInt(req.getParameter("price"));
		//System.out.println(pname+" "+price);
		
//		
		
		
		
	
		
		
		
		
		
	
		Product pr=new Product();
		pr.setpName(pname);
		pr.setPrice(price);
		
		Configuration cfg=new Configuration().configure().addAnnotatedClass(Product.class);
		Session se = cfg.buildSessionFactory().openSession();
		Transaction transaction = se.beginTransaction();
		List<Product> p=new ArrayList<>();
		Query query = se.createQuery("From Product",Product.class);
		p= query.getResultList();
		
		for(Product p1:p) {
			System.out.println(p1.getpName()+" "+p1.getPrice());
			
			System.out.println("----------------------------------------");
		}
        se.persist(pr);
		transaction.commit();
		se.close();
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
	writer.print("<table border='2'>"+
				"<tr>"
			+"<th>id</th>"
				+"<th>pname</th>"
			+"<th>price</th>"+"<th>"+"</th>"
				+"</tr>");
	for(Product p2:p )
	writer.print("<tr>"+
				"<td>"+p2.getpId()+ "</td>"
				+"<td>"+p2.getpName()+"</td>"
				+"<td>"+p2.getPrice()+"</td>"
				 +"<td><a href='Delete?id="+p2.getpId()+"&pname="+p2.getpName()+"&price="+p2.getPrice()+" '>Delete</a> <a href='Update?id="+p2.getpId()+"&pname="+p2.getpName()+"&price="+p2.getPrice()+" '>Update</a></td>"+"</tr>"
				);
	
	writer.print("</table>");
	
		
			
		}
		
	}


