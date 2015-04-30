package com.javaquarium.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javaquarium.business.IPoissonService;
import com.javaquarium.business.IUserPoissonService;
import com.javaquarium.business.PoissonService;
import com.javaquarium.business.UserPoissonService;

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
		final IUserPoissonService userPoissonService = new UserPoissonService();

		// Récupérer les especes de poissons de la base de données
		req.getSession().setAttribute(SESSION_LIST_POISSON, poissonService.getAllPoisson());

		// Récupérer les poissons de l'utilisateur si la variable de session est
		// vide
		@SuppressWarnings("unchecked")
		Map<String, Integer> userPoissons = (Map<String, Integer>) req.getSession().getAttribute(
				com.javaquarium.action.AjoutUserPoissonAction.SESSION_USER_POISSONS);

		if (userPoissons == null) {
			userPoissons = userPoissonService.getUserAllUserPoisson((String) req.getSession().getAttribute(
					com.javaquarium.action.LoginAction.SESSION_USERNAME));
			req.getSession().setAttribute(com.javaquarium.action.AjoutUserPoissonAction.SESSION_USER_POISSONS,
					userPoissons);
		}

		String forward = FW_SUCCESS;
		
		return mapping.findForward(forward);
	}

}
