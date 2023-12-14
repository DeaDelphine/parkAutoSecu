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
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="COMMANDE")
@Data
@RequiredArgsConstructor
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

	
}
