package com.assosetvous.assosetvous.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="CAMION")


public class Camion extends Vehicule{
	
	@Override
	public String demarrer() {
		return "VRROOOOOMMMM!";
	}
	
	@Override
	public String accelerer() {
		return "RRRRRRRRRRR!";
	}
	//Constructeur par défaut
	public Camion() {
		super();	
	}

	public Camion(int anneeModel, double prix, List<Location> locationList, List<Agence> agenceList,
			ModelVehicule modelvehicule) {
		super(anneeModel, prix, locationList, agenceList, modelvehicule);
		// TODO Auto-generated constructor stub
	}

	public Camion(long id, int anneeModel, double prix, List<Location> locationList, List<Agence> agenceList,
			ModelVehicule modelvehicule) {
		super(id, anneeModel, prix, locationList, agenceList, modelvehicule);
		// TODO Auto-generated constructor stub
	}


	


}
