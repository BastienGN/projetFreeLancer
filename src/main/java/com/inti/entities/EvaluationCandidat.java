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
	
	
	private String username;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		
		
	public EvaluationCandidat() {}
	public EvaluationCandidat(Integer note, String username) {
		this.note = note;
		this.username = username;
	}
	
	
	@Override
	public String toString() {
		return "EvaluationCandidate [idEvaluationCandidat=" + idEvaluationCandidat + ", note=" + note
				+ ", username=" + username + "]";
	}
	
}
