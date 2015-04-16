package com.javaquarium.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.javaquarium.beans.web.LoginVO;
import com.javaquarium.business.IUserService;
import com.javaquarium.business.UserService;

/**
 * Login Action.
 * 
 * @author Benoit Brayer
 */
public class LoginAction extends Action {

	/**
	 * Forward called every times.
	 */
	private static final String FW_SUCCESS = "success";
	private static final String FW_FORM_ERROR = "form_error";

	/**
	 * The login name of the authenticated user.
	 */
	public static final String SESSION_USER = "username";

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

		String login = ((LoginVO) form).getLogin();
		String password = ((LoginVO) form).getPassword();

		if (userService.validateLogin(login, password)) {
			req.getSession().setAttribute(SESSION_USER, ((LoginVO) (form)).getLogin());
		} else {
			ActionErrors errors = new ActionErrors();
			errors.add("errors.field.login.incorrect.user_or_password", 
					new ActionMessage(
						"errors.field.login.incorrect.user_or_password"));
			saveErrors(req, errors);
			forward = mapping.findForward(FW_FORM_ERROR);
		}

		return forward;

	}

}
