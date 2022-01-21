package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

public class Candidature implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idCandidature;
		public Long getIdCandidature() {
			return idCandidature;
		}
		public void setIdCandidature(Long idCandidature) {
			this.idCandidature = idCandidature;
		}
		
		
	private String statut;
		public String getStatut() {
			return statut;
		}
		public void setStatut(String statut) {
			this.statut = statut;
		}
		
	private String lettreMotivation;
		public String getLettreMotivation() {
			return lettreMotivation;
		}
		public void setLettreMotivation(String lettreMotivation) {
			this.lettreMotivation = lettreMotivation;
		}
		
		
	@ManyToOne
	private Projet projet;
		public Projet getProjet() {
			return projet;
		}
		public void setProjet(Projet projet) {
			this.projet = projet;
		}
		
		
	public Candidature() {}
	public Candidature(Long idCandidature, String statut, String lettreMotivation) {
		this.statut = statut;
		this.lettreMotivation = lettreMotivation;
	}

	@Override
	public String toString() {
		return "Candidature [idCandidature=" + idCandidature + ", statut=" + statut + ", lettreMotivation="
				+ lettreMotivation + "]";
	}
	
}
