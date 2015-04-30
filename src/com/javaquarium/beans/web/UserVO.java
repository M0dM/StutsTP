package com.javaquarium.beans.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * Java bean of the web login object.
 * 
 * @author Benoit
 */
public class UserVO extends ActionForm {

	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	private String repeatPassword;

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(final String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * @return the repeated password
	 */
	public String getRepeatPassword() {
		return repeatPassword;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setRepeatPassword(final String password) {
		this.repeatPassword = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts.action.ActionForm#validate(org.apache.struts.action
	 * .ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
		final ActionErrors errors = new ActionErrors();

		Properties properties = new Properties();
		String propertiesFileName = "ApplicationResources.properties";

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			System.err.println("property file " + propertiesFileName + "not found in the classpath");
		}

		if (StringUtils.isEmpty(getLogin())) {
			errors.add("login",
					new ActionMessage("errors.field.notFound", properties.get("message.register.input.name.login")));
		}
		if (StringUtils.isEmpty(getPassword())) {
			errors.add("password",
					new ActionMessage("errors.field.notFound", properties.get("message.register.input.name.password")));
		}
		if (StringUtils.isEmpty(getRepeatPassword())) {
			errors.add(
					"repeatPassword",
					new ActionMessage("errors.field.notFound", properties
							.get("message.register.input.name.repeat_password")));
		}
		if (getPassword().length() < 4) {
			errors.add("password_too_small",
					new ActionMessage("errors.field.minlength", properties.get("message.register.input.name.password"),
							"4"));
		}
		if (getPassword().compareTo(getRepeatPassword()) != 0) {
			errors.add("password_not_similar", new ActionMessage("errors.field.password.repeat"));
		}
		return errors;
	}
}
