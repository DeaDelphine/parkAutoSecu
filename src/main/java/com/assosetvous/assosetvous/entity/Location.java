package com.assosetvous.assosetvous.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="LOCATION")
public class Location {

	@Id
	@GeneratedValue(strategy  = GenerationType.AUTO)
	@Column(name = "IDLOCATION")
	private Long id;
	@Column(name = "DATEDEBUT")
	private String datedebut;
	@Column(name = "DATERETOUR")
	private String dateretour;
	@Column(name = "DEBUTLOCATION")
	private String debutlocation;
	
	@ManyToMany
	@JoinTable(name="LocatClient")
	private List<Client> clientList;
	
	
	@JsonIgnore
	@ManyToMany(mappedBy="locationList")
	private List<Vehicule> vehiculeList;
	
	//Constructeurs 
	public Location() {
		super();
	}
	
	
	public Location(String datedebut, String dateretour, String debutlocation, List<Client> clientList,
			List<Vehicule> vehiculeList) {
		super();
		this.datedebut = datedebut;
		this.dateretour = dateretour;
		this.debutlocation = debutlocation;
		this.clientList = clientList;
		this.vehiculeList = vehiculeList;
	}


	public Location(Long id, String datedebut, String dateretour, String debutlocation, List<Client> clientList,
			List<Vehicule> vehiculeList) {
		super();
		this.id = id;
		this.datedebut = datedebut;
		this.dateretour = dateretour;
		this.debutlocation = debutlocation;
		this.clientList = clientList;
		this.vehiculeList = vehiculeList;
	}


	//Accesseurs getter et setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getDatedebut() {
		return datedebut;
	}



	public void setDatedebut(String datedebut) {
		this.datedebut = datedebut;
	}



	public String getDateretour() {
		return dateretour;
	}



	public void setDateretour(String dateretour) {
		this.dateretour = dateretour;
	}



	public String getDebutlocation() {
		return debutlocation;
	}



	public void setDebutlocation(String debutlocation) {
		this.debutlocation = debutlocation;
	}



	public List<Client> getClientList() {
		return clientList;
	}



	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}

	public List<Vehicule> getVehiculeList() {
		return vehiculeList;
	}

	public void setVehiculeList(List<Vehicule> vehiculeList) {
		this.vehiculeList = vehiculeList;
	}

	
	
	
}
