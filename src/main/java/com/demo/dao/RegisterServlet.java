package com.demo.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int sal = Integer.parseInt(req.getParameter("salary"));

		EmpDao dao = new EmpDao();
		boolean isAdded = dao.register(id, name, sal);


		PrintWriter pw = res.getWriter();
		if (isAdded)
			pw.write("<h2 style='color:green'>Registration successful</h2>");
		else
			pw.write("<h2 style='color:red'>Unable to register</h2>");
		pw.close();
	}

}
