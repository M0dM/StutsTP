package com.javaquarium.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Custom filter to avoid users been able to display unauthorized jsp pages when
 * they are not allowed to display them (user not authenticated).
 * 
 * Not autenticated user still can display login and registration pages.
 * 
 * @author Benoit Brayer
 * 
 */
public class AuthFilter implements Filter {

	public static final String LOGIN_WEBPAGE = "/jsp/UC00_login.jsp";
	public static final String REGISTER_WEBPAGE = "UC03_register.jsp";

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
			ServletException {
		/* Cast des objets request et response */
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		/* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();

		String[] requestUrl = request.getRequestURL().toString().split("/");
		String jspName = requestUrl[requestUrl.length - 1];

		/**
		 * Si l'objet utilisateur existe dans la session en cours ou que la page
		 * demandée est la page d'enregistrement
		 */
		if (jspName.compareTo(REGISTER_WEBPAGE) == 0
				|| session.getAttribute(com.javaquarium.action.LoginAction.SESSION_USERNAME) != null) {
			/* Affichage de la page demandée */
			chain.doFilter(request, response);
		} else {
			/* Redirection vers la page de login */
			request.getRequestDispatcher(LOGIN_WEBPAGE).forward(request, response);
		}
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
	}

}
