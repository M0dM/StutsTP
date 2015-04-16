package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javaquarium.business.IPoissonService;
import com.javaquarium.business.PoissonService;

/**
 * ListerEspece Action.
 * 
 * @author Benoit Brayer
 */
public class ListerEspeceAction extends Action {

	/**
	 * Forward called every times.
	 */
	private static final String FW_SUCCESS = "success";

	/**
	 * The name of the session variable containing all the available poisson.
	 */
	public static final String SESSION_LIST_POISSON = "listPoisson";

	/**
	 * Method called by struct following configuration specified inside the
	 * struts-config.xml file.
	 */
	public ActionForward execute(final ActionMapping mapping, 
			final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		final IPoissonService poissonService = new PoissonService();
		req.getSession().setAttribute(SESSION_LIST_POISSON, poissonService.getAllPoisson());
		return mapping.findForward(FW_SUCCESS);
	}

}
