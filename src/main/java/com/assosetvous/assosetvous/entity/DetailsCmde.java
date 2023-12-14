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
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="DETAILSCMDE")
@Data
@RequiredArgsConstructor
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
	


	
}
