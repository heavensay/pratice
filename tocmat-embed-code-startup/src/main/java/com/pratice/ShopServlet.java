package com.pratice;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ShopServlet extends HttpServlet {
	
	private static Logger logger = Logger.getLogger(ShopServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug(" shop ");
		resp.getWriter().write("welcome to shop");
	}
}
