package com.javaquarium.business;

import java.util.ArrayList;
import java.util.List;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.web.PoissonVO;
import com.javaquarium.dao.IPoissonDAO;
import com.javaquarium.dao.PoissonDAO;

/**
 * Poisson Service.
 * 
 * @author Benoit Brayer
 */
public class PoissonService implements IPoissonService {

	private IPoissonDAO dao;

	/**
	 * Poisson service constructor. Initialization of the dao.
	 */
	public PoissonService() {
		dao = new PoissonDAO();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.javaquarium.business.IPoissonService#getAllPoisson()
	 */
	@Override
	public List<PoissonVO> getAllPoisson() {
		final List<PoissonDO> listPoisson = dao.getAllPoisson();
		List<PoissonVO> poissons = new ArrayList<PoissonVO>(listPoisson.size());
		for (final PoissonDO poisson : listPoisson) {
			poissons.add(map(poisson));
		}
		return poissons;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javaquarium.business.IPoissonService#addPoisson(com.javaquarium.beans
	 * .web.PoissonVO)
	 */
	@Override
	public void addPoisson(final PoissonVO poisson) {
		PoissonDO p = this.map(poisson);
		dao.addPoisson(p);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javaquarium.business.IPoissonService#map(com.javaquarium.beans.data
	 * .PoissonDO)
	 */
	public PoissonVO map(final PoissonDO poisson) {
		PoissonVO p = null;
		if (poisson != null) {
			p = new PoissonVO();
			p.setCode(poisson.getId());
			p.setCouleur(poisson.getCouleur());
			p.setDescription(poisson.getDescription());
			p.setDimension(poisson.getLargeur() + "x" + poisson.getLongueur());
			p.setEspece(poisson.getNom());
			p.setPrix(poisson.getPrix() + "");
		}
		return p;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javaquarium.business.IPoissonService#map(com.javaquarium.beans.web
	 * .PoissonVO)
	 */
	public PoissonDO map(final PoissonVO poisson) {
		PoissonDO p = null;
		if (poisson != null) {
			p = new PoissonDO();
			p.setCouleur(poisson.getCouleur());
			p.setDescription(poisson.getDescription());
			p.setId(poisson.getCode());
			p.setLargeur(Float.parseFloat(poisson.getDimension().split("x")[0]));
			p.setLongueur(Float.parseFloat(poisson.getDimension().split("x")[1]));
			p.setNom(poisson.getEspece());
			p.setPrix(Integer.parseInt(poisson.getPrix()));
		}
		return p;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javaquarium.business.IPoissonService#getPoisson(java.lang.String)
	 */
	@Override
	public PoissonVO getPoisson(final String espece) {
		return map(dao.getPoisson(espece));
	}

}
