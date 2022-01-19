package com.inti.entities;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.inti.models.*;

@Entity
public class Freelancer extends Utilisateur
{
	private Integer experience;
	private File cv;
	private Integer note;
	private String sitePersonnel;
	
	//liaison
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ProfilEvaluationEntreprise-Freelancer", joinColumns = @JoinColumn(name = "id_freelancer", referencedColumnName = "idUtilisateur"), 
	inverseJoinColumns = @JoinColumn(name = "id_EvaluationEntreprise", referencedColumnName = "idEvaluationEntreprise"))
	private Set<EvaluationEntreprise> evalutationsEntreprises = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ProfilTest-Freelancer", joinColumns = @JoinColumn(name = "id_freelancer", referencedColumnName = "idUtilisateur"), 
	inverseJoinColumns = @JoinColumn(name = "id_test", referencedColumnName = "idTest"))
	private Set<Test> tests = new HashSet<>();
	
	//Constructeur (vide + paramètre)
	public Freelancer() {
		super();
	}

	public Freelancer(	String nom, String prenom, String username, String password, Adresse adresse,Date dateNaissance, String adresseMail, Long telephone,
						Integer experience, File cv, Integer note, String sitePersonnel) {
		super(nom,prenom,username,password,adresse,dateNaissance,adresseMail,telephone);
		this.experience = experience;
		this.cv = cv;
		this.note = note;
		this.sitePersonnel = sitePersonnel;
	}

	
	//Setter Getter
	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public File getCv() {
		return cv;
	}

	public void setCv(File cv) {
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

	//toString
	@Override
	public String toString() {
		return super.toString()+"Freelancer [experience=" + experience + ", cv=" + cv + ", note=" + note + ", sitePersonnel="
				+ sitePersonnel + "]";
	}

	
}
