package com.inti.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Projet implements Serializable{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idProjet;
	private String titre;
	private String description;
	private double salaire;
	private String statut;

	@OneToMany(mappedBy="projet")
	private Set<Candidature> candidature=new HashSet<>();
	
}
