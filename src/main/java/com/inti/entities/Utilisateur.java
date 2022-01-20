package com.inti.entities;

import java.io.File;
import java.io.Serializable;
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

import com.inti.models.Adresse;

@Entity
@Table(name="table_Utilisateur")
public class Utilisateur implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	@Column(unique = true)
	private String username;
	private String password;
	private Adresse adresse;
	private Date dateNaissance;
	private String adresseMail;
	private Long telephone;
	//Attributs Freelancers
	private Integer experience;
	
	@Lob
	private byte[] cv;
	
	private Integer note;
	private String sitePersonnel;
	// Attributs JobOwner
	private String nomEntreprise;
	private String avis;
	
	private boolean enabled = true;

	@ManyToMany
	@JoinTable(	name = "Profil_Utilisateur_Role",
				joinColumns = @JoinColumn(name = "id_utilisateur", referencedColumnName = "idUtilisateur"),
				inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "idRole"))
	private Set<Role> roles = new HashSet<>();

	@ManyToMany
	@JoinTable(	name = "Profil_Freelancer_EvaluationEntreprise", 
				joinColumns = @JoinColumn(name = "id_freelancer", 
				referencedColumnName = "idUtilisateur"), 
				inverseJoinColumns = @JoinColumn(name = "id_EvaluationEntreprise", referencedColumnName = "idEvaluationEntreprise"))
	private Set<EvaluationEntreprise> evalutationsEntreprises = new HashSet<>();
	
	@ManyToMany
	@JoinTable(	name = "Profil_Freelancer_Test",
				joinColumns = @JoinColumn(name = "id_freelancer", referencedColumnName = "idUtilisateur"), 
				inverseJoinColumns = @JoinColumn(name = "id_test", referencedColumnName = "idTest"))
	private Set<Test> tests = new HashSet<>();
	
	@ManyToMany
	@JoinTable(	name = "Profil_EvaluationCandidat_JobOwner",
				joinColumns = @JoinColumn(name = "id_jobOwner", referencedColumnName = "idUtilisateur"), 
				inverseJoinColumns = @JoinColumn(name = "id_evalCandidat", referencedColumnName = "idEvaluationCandidat"))
	private Set<EvaluationCandidat> evaluationCandidats = new HashSet<>();

	@ManyToMany
	@JoinTable(	name = "Profil_JobOwner_Projet", 
				joinColumns = @JoinColumn(name = "id_jobOwner", referencedColumnName = "idUtilisateur"), 
				inverseJoinColumns = @JoinColumn(name = "id_projet", referencedColumnName = "idProjet"))
	private Set<Projet> projets = new HashSet<>();
	
	public Utilisateur() {
	}
	
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public void setCv(byte[] cv) {
		this.cv = cv;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public String getSitePersonnel() {
		return sitePersonnel;
	}

	public void setSitePersonnel(String sitePersonnel) {
		this.sitePersonnel = sitePersonnel;
	}

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

	public Set<EvaluationEntreprise> getEvalutationsEntreprises() {
		return evalutationsEntreprises;
	}

	public void setEvalutationsEntreprises(Set<EvaluationEntreprise> evalutationsEntreprises) {
		this.evalutationsEntreprises = evalutationsEntreprises;
	}

	public Set<Test> getTests() {
		return tests;
	}

	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}

	public Set<EvaluationCandidat> getEvaluationCandidats() {
		return evaluationCandidats;
	}

	public void setEvaluationCandidats(Set<EvaluationCandidat> evaluationCandidats) {
		this.evaluationCandidats = evaluationCandidats;
	}

	public Set<Projet> getProjets() {
		return projets;
	}

	public void setProjets(Set<Projet> projets) {
		this.projets = projets;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nomUtilisateur=" + nomUtilisateur
				+ ", prenomUtilisateur=" + prenomUtilisateur + ", username=" + username + ", password=" + password
				+ ", adresse=" + adresse + ", dateNaissance=" + dateNaissance + ", adresseMail=" + adresseMail
				+ ", telephone=" + telephone + ", experience=" + experience + ", cv=" + cv + ", note=" + note
				+ ", sitePersonnel=" + sitePersonnel + ", nomEntreprise=" + nomEntreprise + ", avis=" + avis
				+ ", enabled=" + enabled + "]";
	}
}