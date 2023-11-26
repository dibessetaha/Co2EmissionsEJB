package com.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="co2_emissions")
public class Co2Emission implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	
	public Co2Emission(String year, String country) {
		this.year = year;
		this.country = country;
	}
	
	public Co2Emission() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ; 
	private String year ; 
	private String country ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	} 
	
	
	

}
