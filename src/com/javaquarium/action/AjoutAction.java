package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.javaquarium.beans.web.PoissonVO;
import com.javaquarium.business.IPoissonService;
import com.javaquarium.business.PoissonService;

/**
 * AjoutPoisson Action.
 * 
 * @author Benoit Brayer
 */
public class AjoutAction extends Action {

	/**
	 * Forward called every times.
	 */
	private static final String FW_SUCCESS = "success";
	private static final String FW_FORM_ERROR = "form_error";

	/**
	 * Method called by struct following configuration specified inside the
	 * struts-config.xml file.
	 */
	@SuppressWarnings("deprecation")
	public ActionForward execute(final ActionMapping mapping, 
			final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {
		
		String forward = FW_SUCCESS;
		IPoissonService poissonService = new PoissonService();

		PoissonVO oldPoisson = poissonService.getPoisson(((PoissonVO) form).getEspece());

		if (oldPoisson == null) {
			poissonService.addPoisson((PoissonVO) form);
		} else {
			ActionErrors errors = new ActionErrors();
			errors.add("errors.filed.poisson.already.exist", 
					new ActionMessage("errors.filed.poisson.already.exist"));
			saveErrors(req, errors);
			forward = FW_FORM_ERROR;
		}
		
		return mapping.findForward(forward);
	}

}
