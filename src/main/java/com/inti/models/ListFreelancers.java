package com.inti.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class ListFreelancers implements Serializable{
	private String nomFreelancer;
	private String prenomFreelancer;
	
	public ListFreelancers() {
	}

	public ListFreelancers(String nomFreelancer, String prenomFreelancer) {
		this.nomFreelancer = nomFreelancer;
		this.prenomFreelancer = prenomFreelancer;
	}

	public String getNomFreelancer() {
		return nomFreelancer;
	}

	public void setNomFreelancer(String nomFreelancer) {
		this.nomFreelancer = nomFreelancer;
	}

	public String getPrenomFreelancer() {
		return prenomFreelancer;
	}

	public void setPrenomFreelancer(String prenomFreelancer) {
		this.prenomFreelancer = prenomFreelancer;
	}

	@Override
	public String toString() {
		return "ListFreelancers [nomFreelancer=" + nomFreelancer + ", prenomFreelancer=" + prenomFreelancer + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nomFreelancer, prenomFreelancer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListFreelancers other = (ListFreelancers) obj;
		return Objects.equals(nomFreelancer, other.nomFreelancer)
				&& Objects.equals(prenomFreelancer, other.prenomFreelancer);
	}
	
}
