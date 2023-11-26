package com.dao;

import com.entities.Co2Emission;
import java.util.List ; 

public interface ICo2Emissions {
	
	public void addCo2Emisson(Co2Emission co2Emission) ; 
	public List<Co2Emission> getCo2Emissions() ; 
	public Co2Emission getOne(Long id) ; 
	public void approuverCo2Emission(Long id) ; 

}
