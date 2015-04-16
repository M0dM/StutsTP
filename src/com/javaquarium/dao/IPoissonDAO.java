package com.javaquarium.dao;

import java.util.List;

import com.javaquarium.beans.data.PoissonDO;

public interface IPoissonDAO {

	/**
	 * @return all the registred poisson
	 */
	List<PoissonDO> getAllPoisson();

	/**
	 * @param name
	 *            the name of the desired poisson object
	 * @return the corresponding PoissonDO object
	 */
	PoissonDO getPoisson(String name);

	/**
	 * @param p
	 *            the PoissonDO object needed to be insert inside the database
	 */
	void addPoisson(PoissonDO p);

}
