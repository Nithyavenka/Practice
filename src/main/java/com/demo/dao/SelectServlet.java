package com.demo.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		EmpDao dao = new EmpDao();
		Employee e = dao.select(id);
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		pw.write("<h1>Employee ID:: " + e.getId() + "</h1>");
		pw.write("<h1>Employee Name:: " + e.getName() + "</h1>");
		pw.write("<h1>Employee Salary:: " + e.getSal() + "</h1>");
		pw.close();
	}
}