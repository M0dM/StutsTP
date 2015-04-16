package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.javaquarium.business.IUserService;
import com.javaquarium.business.UserService;
import com.javaquarium.beans.web.UserVO;

/**
 * Login Action.
 * 
 * @author Benoit Brayer
 */
public class RegisterAction extends Action {

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

		ActionForward forward = mapping.findForward(FW_SUCCESS);
		IUserService userService = new UserService();
		
		UserVO oldUser = userService.getUser(((UserVO)form).getLogin());
		
		if (oldUser == null) {
			userService.addUser((UserVO)form);
		} else {
			ActionErrors errors = new ActionErrors();
			errors.add("errors.field.login.already.exist", 
					new ActionMessage("errors.field.login.already.exist"));
			saveErrors(req, errors);
			forward = mapping.findForward(FW_FORM_ERROR);
		}
		return forward;
	}

}
