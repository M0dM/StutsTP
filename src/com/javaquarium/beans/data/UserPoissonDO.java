package com.javaquarium.beans.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Java bean of the data poisson object.
 * 
 * @author Benoit Brayer
 */
@Entity
@Table(name = "t_user_poisson")
public class UserPoissonDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "c_id")
	private Integer id;

	@ManyToOne
	private UserDO user;
	
	@ManyToOne
	private PoissonDO poisson;

	@Column(name = "c_count")
	private Integer count;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public UserDO getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserDO user) {
		this.user = user;
	}

	/**
	 * @return the poisson
	 */
	public PoissonDO getPoisson() {
		return poisson;
	}

	/**
	 * @param poisson the poisson to set
	 */
	public void setPoisson(PoissonDO poisson) {
		this.poisson = poisson;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
}
