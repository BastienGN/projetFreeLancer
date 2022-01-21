package com.inti.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="table_Test")
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
		
		
	private String description;
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	
	
	private String resultat;
		public String getResultat() {
			return resultat;
		}
		public void setResultat(String resultat) {
			this.resultat = resultat;
		}
	
	// Constructeur
	public Test(String description,String resultat) {
		this.description = description;
		this.resultat = resultat;
	}
	public Test() {}
	
	@Override
	public String toString() {
		return "Test [idTest=" + idTest + ", description=" + description + ", resultat=" + resultat + "]";
	}
	
	
}
