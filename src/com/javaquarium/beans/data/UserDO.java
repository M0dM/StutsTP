package com.javaquarium.beans.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Java bean of the data poisson object.
 * 
 * @author Benoit Brayer
 */
@Entity
@Table(name = "t_user")
public class UserDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "c_id")
	private Integer id;

	@Column(name = "c_login", nullable = true)
	private String login;

	@Column(name = "c_password_hash", nullable = true)
	private String passwordHash;
	
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
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password hash
	 */
	public String getPasswordHash() {
		return passwordHash;
	}
	
	/**
	 * @param hash the password hash to set
	 */
	public void setPasswordHash(String hash) {
		this.passwordHash = hash;
	}

}
