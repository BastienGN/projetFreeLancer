package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class EvaluationCandidat implements Serializable {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long idEvaluationCandidat;
		public Long getIdEvaluationCandidat() {
			return idEvaluationCandidat;
		}
		public void setIdEvaluationCandidat(Long idEvaluationCandidat) {
			this.idEvaluationCandidat = idEvaluationCandidat;
		}


	private Integer note;
		public Integer getNote() {
			return note;
		}
		public void setNote(Integer note) {
			this.note = note;
		}
	
	
	private String usernameFreelancer;
		public String getUsernameFreelancer() {
			return usernameFreelancer;
		}
		public void setUsernameFreelancer(String usernameFreelancer) {
			this.usernameFreelancer = usernameFreelancer;
		}
		
		
	public EvaluationCandidat() {}
	public EvaluationCandidat(Integer note, String usernameFreelancer) {
		this.note = note;
		this.usernameFreelancer = usernameFreelancer;
	}
	
	
	@Override
	public String toString() {
		return "EvaluationCandidate [idEvaluationCandidat=" + idEvaluationCandidat + ", note=" + note
				+ ", usernameFreelancer=" + usernameFreelancer + "]";
	}
	
}
