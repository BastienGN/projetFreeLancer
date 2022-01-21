package com.inti.entities;

import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.inti.models.Adresse;

@Entity
public class Utilisateur implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;
		public Long getIdUtilisateur() {
		return idUtilisateur;
	}
		public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}


	private String nomUtilisateur;
		public String getNomUtilisateur() {
		return nomUtilisateur;
	}
		public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

		
	private String prenomUtilisateur;
		public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}	
		public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}
	
		
	@Column(unique = true)
	private String username;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
	
		
	private String password;
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	
	
	private String adresseMail;
		public String getAdresseMail() {
			return adresseMail;
		}
		public void setAdresseMail(String adresseMail) {
			this.adresseMail = adresseMail;
		}
	
		
	private Long telephone;
		public Long getTelephone() {
			return telephone;
		}
		public void setTelephone(Long telephone) {
			this.telephone = telephone;
		}
	
		
	private Integer note;
		public Integer getNote() {
			return note;
		}
		public void setNote(Integer note) {
			this.note = note;
		}
	
		
	//Attributs Freelancers
	@Lob
	private byte[] cv;
		public byte[] getCv() {
			return cv;
		}
		public void setCv(byte[] cv) {
			this.cv = cv;
		}
	
		
	// Attributs JobOwner
	private String nomEntreprise;
		public String getNomEntreprise() {
			return nomEntreprise;
		}
		public void setNomEntreprise(String nomEntreprise) {
			this.nomEntreprise = nomEntreprise;
		}
	
		
	//Securité
	private boolean enabled = true;
		public boolean isEnabled() {
			return enabled;
		}
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
		
		
	//Relation
	@ManyToMany
	@JoinTable(	name = "Profil_Utilisateur_Role",
				joinColumns = @JoinColumn(name = "id_utilisateur", referencedColumnName = "idUtilisateur"),
				inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "idRole"))
	private Set<Role> roles = new HashSet<>();
		public Set<Role> getRoles() {
			return roles;
		}
		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}
	
		
	@ManyToMany
	@JoinTable(	name = "Profil_Freelancer_EvaluationEntreprise", 
				joinColumns = @JoinColumn(name = "id_freelancer", 
				referencedColumnName = "idUtilisateur"), 
				inverseJoinColumns = @JoinColumn(name = "id_EvaluationEntreprise", referencedColumnName = "idEvaluationEntreprise"))
	private Set<EvaluationEntreprise> evalutationsEntreprises = new HashSet<>();
		public Set<EvaluationEntreprise> getEvalutationsEntreprises() {
			return evalutationsEntreprises;
		}
		public void setEvalutationsEntreprises(Set<EvaluationEntreprise> evalutationsEntreprises) {
			this.evalutationsEntreprises = evalutationsEntreprises;
		}
	
		
	@ManyToMany
	@JoinTable(	name = "Profil_Freelancer_Test",
				joinColumns = @JoinColumn(name = "id_freelancer", referencedColumnName = "idUtilisateur"), 
				inverseJoinColumns = @JoinColumn(name = "id_test", referencedColumnName = "idTest"))
	private Set<Test> tests = new HashSet<>();
		public Set<Test> getTests() {
			return tests;
		}
		public void setTests(Set<Test> tests) {
			this.tests = tests;
		}
	
		
	@ManyToMany
	@JoinTable(	name = "Profil_JobOwner_EvaluationCandidat",
				joinColumns = @JoinColumn(name = "id_jobOwner", referencedColumnName = "idUtilisateur"), 
				inverseJoinColumns = @JoinColumn(name = "id_evalCandidat", referencedColumnName = "idEvaluationCandidat"))
	private Set<EvaluationCandidat> evaluationCandidats = new HashSet<>();
		public Set<EvaluationCandidat> getEvaluationCandidats() {
			return evaluationCandidats;
		}
		public void setEvaluationCandidats(Set<EvaluationCandidat> evaluationCandidats) {
			this.evaluationCandidats = evaluationCandidats;
		}
	
		
	@ManyToMany
	@JoinTable(	name = "Profil_JobOwner_Projet", 
				joinColumns = @JoinColumn(name = "id_jobOwner", referencedColumnName = "idUtilisateur"), 
				inverseJoinColumns = @JoinColumn(name = "id_projet", referencedColumnName = "idProjet"))
	private Set<Projet> projets = new HashSet<>();
		public Set<Projet> getProjets() {
		return projets;
	}
		public void setProjets(Set<Projet> projets) {
	this.projets = projets;
}
	
		
	public Utilisateur() {}
	
	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nomUtilisateur=" + nomUtilisateur
				+ ", prenomUtilisateur=" + prenomUtilisateur + ", username=" + username + ", password=" + password
				+ ", adresseMail=" + adresseMail + ", telephone=" + telephone + ", note=" + note + ", cv=" + Arrays.toString(cv) + ", nomEntreprise=" + nomEntreprise + ", enabled="
				+ enabled + "]";
	}
		
}