package com.inti.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	
	private String username;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		
		
	//Constructeur( vide+params)
	public EvaluationEntreprise() {}
	
	public EvaluationEntreprise(Integer note, String username) {
		super();
		this.note = note;
		this.username = username;
	}
	
	
	@Override
	public String toString() {
		return "EvaluationEntreprise [idEvaluationEntreprise=" + idEvaluationEntreprise + ", note=" + note
				+ ", username=" + username + "]";
	}
	

	
	
	
}
