package com.javaquarium.beans.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Java bean of the data poisson object.
 * 
 * @author Benoit Brayer
 */
@Entity
@Table(name = "t_poisson")
public class PoissonDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "c_id")
	private Integer id;

	@Column(name = "c_couleur", nullable = true)
	private String couleur;

	@Column(name = "c_description", nullable = true)
	private String description;

	@Column(name = "c_largeur", nullable = true)
	private float largeur;

	@Column(name = "c_longueur", nullable = true)
	private float longueur;

	@Column(name = "c_prix", nullable = true)
	private int prix;

	@Column(name = "c_nom", nullable = true)
	private String nom;
	
	@OneToMany( targetEntity=UserPoissonDO.class )
    private List<UserPoissonDO> userPoissons;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getCouleur() {
		return couleur;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
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
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the largeur
	 */
	public float getLargeur() {
		return largeur;
	}

	/**
	 * @param largeur
	 *            the largeur to set
	 */
	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}

	/**
	 * @return the longueur
	 */
	public float getLongueur() {
		return longueur;
	}

	/**
	 * @param longueur
	 *            the longueur to set
	 */
	public void setLongueur(float longueur) {
		this.longueur = longueur;
	}

	/**
	 * @return the prix
	 */
	public int getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(int prix) {
		this.prix = prix;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the userPoissons
	 */
	public List<UserPoissonDO> getUserPoissons() {
		return userPoissons;
	}

	/**
	 * @param userPoissons the userPoissons to set
	 */
	public void setUserPoissons(List<UserPoissonDO> userPoissons) {
		this.userPoissons = userPoissons;
	}

}
