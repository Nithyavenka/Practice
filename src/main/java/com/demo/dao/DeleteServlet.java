package com.demo.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		int id = Integer.parseInt(req.getParameter("id"));

		EmpDao dao = new EmpDao();
		boolean isAdded = dao.delete(id);

		PrintWriter pw = res.getWriter();
		if (isAdded)
			pw.write("<h2 style='color:green'>Deleted successful</h2>");
		else
			pw.write("<h2 style='color:red'>Unable to delete</h2>");
		pw.close();

	}
}

