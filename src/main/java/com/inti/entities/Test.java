package com.inti.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
		@ManyToMany
		@JoinTable(	name = "Profil_Test_Freelancer",
					joinColumns = @JoinColumn(name = "id_test", referencedColumnName = "idTest"), 
					inverseJoinColumns = @JoinColumn(name = "id_freelancer", referencedColumnName = "idUtilisateur"))
		private Set<Utilisateur> utilisateurs = new HashSet<>();
	public Set<Utilisateur> getUtilisateurs() {
			return utilisateurs;
		}
		public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
			this.utilisateurs = utilisateurs;
		}
		
		
	// Constructeur
	public Test(String description, String resultat, Set<Utilisateur> utilisateurs) {
		super();
		this.description = description;
		this.resultat = resultat;
		this.utilisateurs = utilisateurs;
	}
	public Test() {}
	
	@Override
	public String toString() {
		return "Test [idTest=" + idTest + ", description=" + description + ", resultat=" + resultat + "]";
	}
	
	
}
