package com.inti.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EvaluationEntreprise {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long idEvaluationEntreprise;
	// private Boolean direction; suppression car il n'y a plus de double sens
	private Integer note;
	private String description;
	
	//Constructeur( vide+params)
	public EvaluationEntreprise() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EvaluationEntreprise(Integer note, String description) {
		super();
		this.note = note;
		this.description = description;
	}
	
	//Setter et Getter
	public Long getIdEvaluationEntreprise() {
		return idEvaluationEntreprise;
	}
	public void setIdEvaluationEntreprise(Long idEvaluationEntreprise) {
		this.idEvaluationEntreprise = idEvaluationEntreprise;
	}
	public Integer getNote() {
		return note;
	}
	public void setNote(Integer note) {
		this.note = note;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	//tostring
	@Override
	public String toString() {
		return "EvaluationEntreprise [idEvaluationEntreprise=" + idEvaluationEntreprise + ", note=" + note
				+ ", description=" + description + "]";
	}
	
	
	
}
