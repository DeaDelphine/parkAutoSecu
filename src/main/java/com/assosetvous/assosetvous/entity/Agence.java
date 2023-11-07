package com.assosetvous.assosetvous.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="AGENCE")
public class Agence {

	@Id
	@GeneratedValue(strategy  = GenerationType.AUTO)
	@Column(name = "IDAGENCE")
	private Long id;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "ADRESSE")
	private String adresse;
	@Column(name = "CP")
	private String cp;
	@Column(name = "VILLE")
	private String ville;
	@Column(name = "CAPACITE")
	private String capacite;
	
	@ManyToMany
	@JoinTable(name="AgenVehicule")
	private List<Vehicule> vehiculeList;
	
	@ManyToMany(mappedBy="agenceList")
	private List<Client> clientList;
	

	public Agence(String nom, String adresse, String cp, String ville, String capacite, List<Vehicule> vehiculeList,
			List<Client> clientList) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.capacite = capacite;
		this.vehiculeList = vehiculeList;
		this.clientList = clientList;
	}

	public Agence(Long id, String nom, String adresse, String cp, String ville, String capacite,
			List<Vehicule> vehiculeList, List<Client> clientList) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.capacite = capacite;
		this.vehiculeList = vehiculeList;
		this.clientList = clientList;
	}

	public Agence() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCapacite() {
		return capacite;
	}

	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}

	public List<Vehicule> getVehiculeList() {
		return vehiculeList;
	}

	public void setVehiculeList(List<Vehicule> vehiculeList) {
		this.vehiculeList = vehiculeList;
	}

	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}
	
	
}
