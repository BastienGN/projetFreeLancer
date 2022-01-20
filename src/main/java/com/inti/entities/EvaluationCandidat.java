package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="table_Evaluation_Candidat")
public class EvaluationCandidat implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEvaluationCandidat;
	private int note;
	private String description;


	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getIdEvaluationCandidat() {
		return idEvaluationCandidat;
	}

	public void setIdEvaluationCandidat(Long idEvaluationCandidat) {
		this.idEvaluationCandidat = idEvaluationCandidat;
	}

	public EvaluationCandidat() {

	}

	public EvaluationCandidat(boolean direction, int note, String description) {
		super();
		this.note = note;
		this.description = description;
	}

	@Override
	public String toString() {
		return "EvaluationCandidat [idEvaluationCandidat=" + idEvaluationCandidat + ", note=" + note + ", description=" + description + "]";
	}

}
