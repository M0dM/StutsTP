package com.javaquarium.business;

import java.util.List;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.web.PoissonVO;

/**
 * Interface of PoissonService.
 * 
 * @author Benoit
 */
public interface IPoissonService {

	/**
	 * @return the list of all registred poisson
	 */
	List<PoissonVO> getAllPoisson();

	/**
	 * @param poisson
	 * @return the poissondo object corrsponding to the poissonvo object
	 */
	PoissonDO map(PoissonVO poisson);

	/**
	 * @param poisson
	 * @return the poissonvo object corrsponding to the poissondo object
	 */
	PoissonVO map(PoissonDO poisson);

	/**
	 * @param poisson
	 *            the poisson needed to be registred into the database
	 */
	void addPoisson(PoissonVO poisson);

	/**
	 * @param espece
	 *            the poissonDO name
	 * @return the corresponding poissonVO object
	 */
	PoissonVO getPoisson(String espece);

}
