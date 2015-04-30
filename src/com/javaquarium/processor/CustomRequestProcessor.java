package com.javaquarium.processor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.RequestProcessor;

import com.javaquarium.action.LoginAction;

/**
 * Custom request processor class to restrict access to disconnected users.
 * 
 * @author Benoit Brayer
 */
public class CustomRequestProcessor extends RequestProcessor {

	/**
	 * Check if user is allowed to visit the desired webpage.
	 * 
	 * @param request
	 *            the http request
	 * @param response
	 *            the http response
	 * @return true if the user can visit the webpage and false if the user is
	 *         not allowed to.
	 */
	protected boolean processPreprocess(HttpServletRequest request, HttpServletResponse response) {
		boolean returnVal = false;

		HttpSession session = request.getSession();

		System.out.println(request.getServletPath());

		// Allow all users to visit login and register webpage
		if (request.getServletPath().equals("/login.do") || request.getServletPath().equals("/register.do")
				|| request.getServletPath().equals("/jsp/UC00_login.jsp")
				|| request.getServletPath().equals("/jsp/UC03_register.jsp")) {
			returnVal = true;
		} else {
			if (session != null && session.getAttribute(LoginAction.SESSION_USERNAME) != null) {
				returnVal = true;
			}
			// not authenticated users trying to visit any other pages are
			// redirected to the login webpage.
			else {
				returnVal = false;
				try {
					request.getRequestDispatcher("/jsp/UC00_login.jsp").forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return returnVal;
	}
}
