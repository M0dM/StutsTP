package com.javaquarium.beans.data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	private Integer id;

	private UserDO user;

	private PoissonDO poisson;

	private Integer count;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "c_id")
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
	 * @return the user
	 */
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "user")
	public UserDO getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(UserDO user) {
		this.user = user;
	}

	/**
	 * @return the poisson
	 */
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "poisson")
	public PoissonDO getPoisson() {
		return poisson;
	}

	/**
	 * @param poisson
	 *            the poisson to set
	 */
	public void setPoisson(PoissonDO poisson) {
		this.poisson = poisson;
	}

	/**
	 * @return the count
	 */
	@Column(name = "c_count")
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

}
