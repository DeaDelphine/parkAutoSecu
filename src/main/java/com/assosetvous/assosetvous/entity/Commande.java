package com.assosetvous.assosetvous.entity;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="COMMANDE")
public class Commande {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.AUTO)
	@Column(name = "IDCOMMANDE")
	private Long id;
	@Column(name = "QUANTITY")
	private int quantity;
	@Column(name = "DATECMD")
	private String date;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "PRIX")
	private double prix;
	@Column(name = "PRIXTOTAL")
	private double prixTotal;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	@OneToMany(mappedBy = "commande")
	private List<DetailsCmde> detailsCmdeList;
	
	
	
	//Constructeurs
	public Commande() {
		super();
	}
	
	//je rajoute un commentaire on s'en fou
	public Commande(Long id, int quantity, String date, String description, double prix, double prixTotal,
			Client client, List<DetailsCmde> detailsCmdeList) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.date = date;
		this.description = description;
		this.prix = prix;
		this.prixTotal = prixTotal;
		this.client = client;
		this.detailsCmdeList = detailsCmdeList;
	}
	

	


	public Commande(int quantity, String date, String description, double prix, double prixTotal, Client client,
			List<DetailsCmde> detailsCmdeList) {
		super();
		this.quantity = quantity;
		this.date = date;
		this.description = description;
		this.prix = prix;
		this.prixTotal = prixTotal;
		this.client = client;
		this.detailsCmdeList = detailsCmdeList;
	}


	//Getters et setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public double getPrixTotal() {
		return prixTotal;
	}
	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<DetailsCmde> getDetailsCmdeList() {
		return detailsCmdeList;
	}


	public void setDetailsCmdeList(List<DetailsCmde> detailsCmdeList) {
		this.detailsCmdeList = detailsCmdeList;
	}
	
}
