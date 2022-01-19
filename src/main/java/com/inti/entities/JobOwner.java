package com.inti.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.inti.models.Adresse;

@Entity
public class JobOwner extends Utilisateur implements Serializable {

	private String nomEntreprise;
	private String avis;
	@ManyToMany
	@JoinTable( name = "JobOwnerEvaluationCandidatrrrrrr",
    joinColumns = @JoinColumn( name = "idUtilisateur"),
    inverseJoinColumns = @JoinColumn( name = "idEvaluationCandidat" ) )
	private Set<EvaluationCandidat> EvaluationCandidats = new HashSet();

	@ManyToMany
	@JoinTable( name = "JobOwnerProject",
    joinColumns = @JoinColumn( name = "idUtilisateur" ),
    inverseJoinColumns = @JoinColumn( name = "idProjet" ) )
	private Set<Projet> Projets = new HashSet();

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}

	public Set<EvaluationCandidat> getEvaluationCandidats() {
		return EvaluationCandidats;
	}

	public void setEvaluationCandidats(Set<EvaluationCandidat> evaluationCandidats) {
		EvaluationCandidats = evaluationCandidats;
	}

	public Set<Projet> getProjets() {
		return Projets;
	}

	public void setProjets(Set<Projet> projets) {
		Projets = projets;
	}

	public JobOwner() {
		super();
	}

	public JobOwner(	String nom, String prenom, String username, String password, Adresse adresse,Date dateNaissance, String adresseMail, Long telephone, String nomEntreprise, String avis, Set<EvaluationCandidat> evaluationCandidats,
			Set<Projet> projets) {
		super(nom,prenom,username,password,adresse,dateNaissance,adresseMail,telephone);
		this.nomEntreprise = nomEntreprise;
		this.avis = avis;
	}

	@Override
	public String toString() {
		return "JobOwner [nomEntreprise=" + nomEntreprise + ", avis=" + avis + "]";
	}
	
	

}
