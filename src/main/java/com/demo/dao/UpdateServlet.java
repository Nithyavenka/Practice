package com.demo.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");

		String empSalaryParam = req.getParameter("salary");
		String empIdParam = req.getParameter("id");

		if (empSalaryParam == null || empIdParam == null) {
			// handle null parameter values
			res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameter values");
			return;
		}

		int sal = Integer.parseInt(empSalaryParam);
		int id = Integer.parseInt(empIdParam);

		EmpDao dao = new EmpDao();
		boolean isAdded = dao.update(id, sal);

		PrintWriter pw = res.getWriter();
		if (isAdded)
			pw.write("<h2 style='color:green'>Updated successfully</h2>");
		else
			pw.write("<h2 style='color:red'>Unable to Update</h2>");
		pw.close();

	}

}