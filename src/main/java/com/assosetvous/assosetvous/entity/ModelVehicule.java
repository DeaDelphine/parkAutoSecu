package com.assosetvous.assosetvous.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="MODELEVEHICULE")
public class ModelVehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDMODELE")
	private long id;
	@Column(name = "MARQUE")
	private String marque;
	@Column(name = "PRIXJOURNEE")
	private double prixJournee;
	
	@OneToMany(mappedBy = "modelvehicule")
	private List<Vehicule> vehiculeList;
	
	

	public ModelVehicule(String marque, double prixJournee, List<Vehicule> vehiculeList) {
		super();
		this.marque = marque;
		this.prixJournee = prixJournee;
		this.vehiculeList = vehiculeList;
	}

	public ModelVehicule(long id, String marque, double prixJournee, List<Vehicule> vehiculeList) {
		super();
		this.id = id;
		this.marque = marque;
		this.prixJournee = prixJournee;
		this.vehiculeList = vehiculeList;
	}

	public ModelVehicule() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public double getPrixJournee() {
		return prixJournee;
	}

	public void setPrixJournee(double prixJournee) {
		this.prixJournee = prixJournee;
	}

	public List<Vehicule> getVehiculeList() {
		return vehiculeList;
	}

	public void setVehiculeList(List<Vehicule> vehiculeList) {
		this.vehiculeList = vehiculeList;
	}
	
	
}
