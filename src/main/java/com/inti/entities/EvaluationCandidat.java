package com.inti.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
		
		@ManyToMany(fetch = FetchType.EAGER)
		@JoinTable(	name = "Profil_EvaluationCandidat_JobOwner",
					joinColumns = @JoinColumn(name = "id_evalCandidat", referencedColumnName = "idEvaluationCandidat"), 
					inverseJoinColumns = @JoinColumn(name = "id_jobOwner", referencedColumnName = "idUtilisateur"))
		private Set<Utilisateur> utilisateurs = new HashSet<>();
	public Set<Utilisateur> getUtilisateurs() {
			return utilisateurs;
		}
		public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
			this.utilisateurs = utilisateurs;
		}
		
		
	public EvaluationCandidat() {}
	public EvaluationCandidat(Integer note, String usernameFreelancer) {
		this.note = note;
		this.usernameFreelancer = usernameFreelancer;
	}
	public EvaluationCandidat(Integer note, String usernameFreelancer, Set<Utilisateur> utilisateurs) {
		super();
		this.note = note;
		this.usernameFreelancer = usernameFreelancer;
		this.utilisateurs = utilisateurs;
	}
	
	
	@Override
	public String toString() {
		return "EvaluationCandidate [idEvaluationCandidat=" + idEvaluationCandidat + ", note=" + note
				+ ", usernameFreelancer=" + usernameFreelancer + "]";
	}
	
}
