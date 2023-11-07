package com.assosetvous.assosetvous.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="vehicule")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Vehicule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDVEHICULE")
	private long id;
	
	@Column(name = "ANNEEMODEL")
	private int anneeModel;
	
	@Column(name = "PRIX")
	private double prix;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="LocatVehicule")
	private List<Location> locationList;
	
	@ManyToMany(mappedBy="vehiculeList")
	private List<Agence> agenceList;
	
	@ManyToOne
	@JoinColumn(name="modelvehicule_id")
	private ModelVehicule modelvehicule;
	
	//Constructeurs 
	
	public Vehicule() {
		super();
	}

	
	
	public Vehicule(int anneeModel, double prix, List<Location> locationList, List<Agence> agenceList,
			ModelVehicule modelvehicule) {
		super();
		this.anneeModel = anneeModel;
		this.prix = prix;
		this.locationList = locationList;
		this.agenceList = agenceList;
		this.modelvehicule = modelvehicule;
	}



	public Vehicule(long id, int anneeModel, double prix, List<Location> locationList, List<Agence> agenceList,
			ModelVehicule modelvehicule) {
		super();
		this.id = id;
		this.anneeModel = anneeModel;
		this.prix = prix;
		this.locationList = locationList;
		this.agenceList = agenceList;
		this.modelvehicule = modelvehicule;
	}



	//Accesseurs getter et setter
	public void setId(long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAnneeModel() {
		return anneeModel;
	}
	public void setAnneeModel(int anneeModel) {
		this.anneeModel = anneeModel;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public List<Location> getLocationList() {
		return locationList;
	}
	public void setLocationList(List<Location> locationList) {
		this.locationList = locationList;
	}

	
	public List<Agence> getAgenceList() {
		return agenceList;
	}



	public void setAgenceList(List<Agence> agenceList) {
		this.agenceList = agenceList;
	}



	public ModelVehicule getModelvehicule() {
		return modelvehicule;
	}



	public void setModelvehicule(ModelVehicule modelvehicule) {
		this.modelvehicule = modelvehicule;
	}



	@Override
	public String toString() {
		return "Véhicule [id=" + id + ", anneeModel=" + anneeModel + ", prix=" + prix + "]";
	}
	
	public String demarrer() {
		return "Véhicule démarré !!";
	}

	public String accelerer() {
		return "Véhicule accelère !!";
	}
}
