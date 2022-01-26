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
public class EvaluationEntreprise {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long idEvaluationEntreprise;
		public Long getIdEvaluationEntreprise() {
			return idEvaluationEntreprise;
		}
		public void setIdEvaluationEntreprise(Long idEvaluationEntreprise) {
			this.idEvaluationEntreprise = idEvaluationEntreprise;
		}


	private Integer note;
		public Integer getNote() {
			return note;
		}
		public void setNote(Integer note) {
			this.note = note;
		}
	
	
	private String usernameJobowner;
		public String getUsernameJobowner() {
			return usernameJobowner;
		}
		public void setUsernameJobowner(String usernameJobowner) {
			this.usernameJobowner = usernameJobowner;
		}
		
		
	//Constructeur( vide+params)
	public EvaluationEntreprise() {}
	
	public EvaluationEntreprise(Integer note, String usernameJobowner) {
		super();
		this.note = note;
		this.usernameJobowner = usernameJobowner;	
	}
	
	public EvaluationEntreprise(Integer note, String usernameJobowner, Set<Utilisateur> utilisateurs) {
		super();
		this.note = note;
		this.usernameJobowner = usernameJobowner;
		this.utilisateurs = utilisateurs;
	}


	//Nouveau ManyToMany ici
	@ManyToMany
	@JoinTable(	name = "Profil_EvaluationEntreprise_Freelancer", 
				joinColumns = @JoinColumn(name = "id_EvaluationEntreprise", 
				referencedColumnName = "idEvaluationEntreprise"), 
				inverseJoinColumns = @JoinColumn(name = "id_freelancer", referencedColumnName = "idUtilisateur"))
	private Set<Utilisateur> utilisateurs = new HashSet<>();
	public Set<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	
	
	@Override
	public String toString() {
		return "EvaluationEntreprise [idEvaluationEntreprise=" + idEvaluationEntreprise + ", note=" + note
				+ ", usernameJobowner=" + usernameJobowner + "]";
	}
	

	
	
	
}
