package com.inti.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Test 
{
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long idTest;
	private String description;
	private Boolean resultat;
	
	
	// Constructeur
	public Test(String description, Boolean resultat) {
		super();
		this.description = description;
		this.resultat = resultat;
	}
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Setter Getter
	public Long getIdTest() {
		return idTest;
	}
	public void setIdTest(Long idTest) {
		this.idTest = idTest;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getResultat() {
		return resultat;
	}
	public void setResultat(Boolean resultat) {
		this.resultat = resultat;
	}
	
	//toString
	@Override
	public String toString() {
		return "Test [idTest=" + idTest + ", description=" + description + ", resultat=" + resultat + "]";
	}
	
	
}
