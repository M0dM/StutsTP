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
 * Java bean of the web poisson object.
 * 
 * @author Benoit Brayer
 */
public class PoissonVO extends ActionForm {

	private static final long serialVersionUID = 1L;
	private Integer code;
	private String espece;
	private String description;
	private String couleur;
	private String dimension;
	private String prix;

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(final Integer code) {
		this.code = code;
	}

	/**
	 * @return the espece
	 */
	public String getEspece() {
		return espece;
	}

	/**
	 * @param espece
	 *            the espece to set
	 */
	public void setEspece(final String espece) {
		this.espece = espece;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * @return the couleur
	 */
	public String getCouleur() {
		return couleur;
	}

	/**
	 * @param couleur
	 *            the couleur to set
	 */
	public void setCouleur(final String couleur) {
		this.couleur = couleur;
	}

	/**
	 * @return the dimension
	 */
	public String getDimension() {
		return dimension;
	}

	/**
	 * @param dimension
	 *            the dimension to set
	 */
	public void setDimension(final String dimension) {
		this.dimension = dimension;
	}

	/**
	 * @return the prix
	 */
	public String getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(final String prix) {
		this.prix = prix;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts.action.ActionForm#validate(org.apache.struts.action
	 * .ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public ActionErrors validate(final ActionMapping mapping, 
		final HttpServletRequest request) {
		final ActionErrors errors = new ActionErrors();

		Properties properties = new Properties();
		String propertiesFileName = "ApplicationResources.properties";

		InputStream inputStream = getClass().getClassLoader()
				.getResourceAsStream(propertiesFileName);
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			System.err.println("property file " 
		+ propertiesFileName + "not found in the classpath");
		}

		if (StringUtils.isEmpty(getEspece())) {
			errors.add("nom",
					new ActionMessage("errors.field.notFound", 
						properties.get("message.ajout.input.title.name")));
		}
		if (StringUtils.isEmpty(getPrix())) {
			errors.add("prix",
					new ActionMessage("errors.field.notFound", 
						properties.get("message.ajout.input.title.price")));
		}
		if (StringUtils.isEmpty(getDimension())) {
			errors.add("dimension",
					new ActionMessage("errors.field.notFound", 
					properties.get("message.ajout.input.title.dimensions")));
		}
		if (!getDimension().matches("((\\d)+(\\.(\\d)+){0,1})x((\\d)+(\\.(\\d)+){0,1})")) {
			errors.add(
					"dimension",
					new ActionMessage("errors.field.dimension.format.not.valid",
					properties.get("message.ajout.input.title.dimensions")));
		}
		try {
			Integer.parseInt(getPrix());
		} catch (NumberFormatException e) {
			errors.add("prix",
					new ActionMessage("errors.field.notInteger",
						properties.get("message.ajout.input.title.price")));
		}

		return errors;
	}
}
