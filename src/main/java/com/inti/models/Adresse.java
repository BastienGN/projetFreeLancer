package com.inti.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse implements Serializable{
	private String rue;
	private String codePostal;
	private String Pays;
	
	public Adresse() {
	}

	public Adresse(String rue, String codePostal, String pays) {
		this.rue = rue;
		this.codePostal = codePostal;
		Pays = pays;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getPays() {
		return Pays;
	}

	public void setPays(String pays) {
		Pays = pays;
	}

	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", codePostal=" + codePostal + ", Pays=" + Pays + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Pays, codePostal, rue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adresse other = (Adresse) obj;
		return Objects.equals(Pays, other.Pays) && Objects.equals(codePostal, other.codePostal)
				&& Objects.equals(rue, other.rue);
	}
	
}
