package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

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
		
	private String username;
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}


	@ManyToOne
	@Transient
	private Projet projet;
		public Projet getProjet() {
			return projet;
		}
		public void setProjet(Projet projet) {
			this.projet = projet;
		}
		
		
	public Candidature() {}
	public Candidature(Long idCandidature, String statut, String lettreMotivation, String username) {
		this.statut = statut;
		this.lettreMotivation = lettreMotivation;
		this.username=username;
	}

	@Override
	public String toString() {
		return "Candidature [idCandidature=" + idCandidature + ", statut=" + statut + ", lettreMotivation="
				+ lettreMotivation + "]";
	}
	
}
