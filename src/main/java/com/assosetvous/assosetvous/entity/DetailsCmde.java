package com.assosetvous.assosetvous.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="DETAILSCMDE")
public class DetailsCmde {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.AUTO)
	@Column(name = "IDDETAILSCMDE")
	private Long id;
	@Column(name = "QTETOTALE")
	private int qteTotale;
	@Column(name = "DATECMDE")
	private Date dateCmd;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "PRIX")
	private double prix;
	@Column(name = "PRIXTOTAL")
	private double prixTotal;
	
	//!! Attention la valeur du  name doit correspondre à celui présent dans Commande au niveau du MappedBy private .. 
	@ManyToOne
	@JoinColumn(name="cmdeDetails")
	private Commande commande;
	

	public DetailsCmde() {
		super();
	}
	public DetailsCmde(Long id, int qteTotale, Date dateCmd, String description, double prix, double prixTotal,
			Commande commande) {
		super();
		this.id = id;
		this.qteTotale = qteTotale;
		this.dateCmd = dateCmd;
		this.description = description;
		this.prix = prix;
		this.prixTotal = prixTotal;
		this.commande = commande;
	}

	public DetailsCmde(int qteTotale, Date dateCmd, String description, double prix, double prixTotal,
			Commande commande) {
		super();
		this.qteTotale = qteTotale;
		this.dateCmd = dateCmd;
		this.description = description;
		this.prix = prix;
		this.prixTotal = prixTotal;
		this.commande = commande;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQteTotale() {
		return qteTotale;
	}

	public void setQteTotale(int qteTotale) {
		this.qteTotale = qteTotale;
	}

	public Date getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
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

	
}
