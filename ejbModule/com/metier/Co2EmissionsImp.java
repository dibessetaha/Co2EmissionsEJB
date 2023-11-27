package com.metier;

import java.util.List;

import com.dao.ICo2Emissions;
import com.entities.Co2Emission;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class Co2EmissionsImp implements ICo2Emissions {

	@PersistenceContext
	private EntityManager em ; 
	
	
	@Override
	public void addCo2Emisson(Co2Emission co2Emission) {
		em.persist(co2Emission);
	}

	@Override
	public List<Co2Emission> getCo2Emissions() {
		Query req = em.createQuery("Select c from Co2Emission c ") ; 
		return req.getResultList();
	}

	@Override
	public Co2Emission getOne(Long id) {
		Co2Emission co2Emission = em.find(Co2Emission.class, id) ; 
		if(co2Emission == null) throw new RuntimeException("Data not found") ; 
		return co2Emission ;
	}

	@Override
	public void approuverCo2Emission(Long id) {
		Co2Emission co2Emission =  getOne(id) ; 
		co2Emission.setApprouved(true);
		em.persist(co2Emission);  // not obligated it made automatically
	}

}
