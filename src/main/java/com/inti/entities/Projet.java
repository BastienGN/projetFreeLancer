package com.inti.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
public class Projet implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idProjet;
		public Long getIdProjet() {
			return idProjet;
		}
		public void setIdProjet(Long idProjet) {
			this.idProjet = idProjet;
		}
	
		
	private String titre;
		public String getTitre() {
			return titre;
		}
		public void setTitre(String titre) {
			this.titre = titre;
		}
		
		
	private String statut;
		public String getStatut() {
			return statut;
		}
		public void setStatut(String statut) {
			this.statut = statut;
		}
	
	@OneToMany(mappedBy="projet")
	@Transient
	private Set<Candidature> candidature=new HashSet<>();
		public Set<Candidature> getCandidature() {
			return candidature;
		}
		public void setCandidature(Set<Candidature> candidature) {
			this.candidature = candidature;
		}
		
		
		@ManyToMany
		@JoinTable(	name = "Profil_Projet_JobOwner", 
					joinColumns = @JoinColumn(name = "id_projet", referencedColumnName = "idProjet"), 
					inverseJoinColumns = @JoinColumn(name = "id_jobOwner", referencedColumnName = "idUtilisateur"))
		private Set<Utilisateur> utilisateurs = new HashSet<>();
	public Set<Utilisateur> getUtilisateurs() {
			return utilisateurs;
		}
		public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
			this.utilisateurs = utilisateurs;
		}
		
		
	public Projet() {}
	public Projet(String titre, String statut) {
		this.titre = titre;
		this.statut = statut;
	}
	public Projet(String titre, String statut, Set<Utilisateur> utilisateurs) {
		super();
		this.titre = titre;
		this.statut = statut;
		this.utilisateurs = utilisateurs;
	}
	
	
	@Override
	public String toString() {
		return "Projet [idProjet=" + idProjet + ", titre=" + titre + ", statut=" + statut + "]";
	}


	
}
