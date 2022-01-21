package com.inti.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Test 
{
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long idTest;
		public Long getIdTest() {
			return idTest;
		}
		public void setIdTest(Long idTest) {
			this.idTest = idTest;
		}
		
		
	private String resultat;
		public String getResultat() {
			return resultat;
		}
		public void setResultat(String resultat) {
			this.resultat = resultat;
		}
		
		
	// Constructeur
	public Test() {}
	public Test(String resultat) {
		this.resultat = resultat;
	}
	
	
	@Override
	public String toString() {
		return "Test [idTest=" + idTest + ", description=" +  ", resultat=" + resultat + "]";
	}
	
	
}
