package com.javaquarium.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javaquarium.business.IUserPoissonService;
import com.javaquarium.business.UserPoissonService;

public class SauvegarderUserPoissonAction extends Action {

	/**
	 * Forward called every times.
	 */
	private static final String FW_SUCCESS = "success";
	
	/**
	 * Method called by struct following configuration specified inside the
	 * struts-config.xml file.
	 */
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		// On recupere la variable de session
		final String login = (String) req.getSession().getAttribute(com.javaquarium.action.LoginAction.SESSION_USERNAME);
		
		/* clée : espece_id / valeur : nombre de poissons de cet utilisateur */
		@SuppressWarnings("unchecked")
		Map<String, Integer> userPoissons = (Map<String, Integer>) req.getSession().getAttribute(
				com.javaquarium.action.AjoutUserPoissonAction.SESSION_USER_POISSONS);

		// On instancie le service UserPoisson
		IUserPoissonService userPoissonService = new UserPoissonService();
		
		/* l'utilisateur possède des poissons en session */
		if (userPoissons != null) {
			for(String key : userPoissons.keySet()) {
				int count = userPoissons.get(key);
				/* On enregistre / met a jour chaque type de poisson */
				userPoissonService.addUserPoisson(login, key, count);
			}
		}
		
		final String forward = FW_SUCCESS;

		return mapping.findForward(forward);
	}
	
}
