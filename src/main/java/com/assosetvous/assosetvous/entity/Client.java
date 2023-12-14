package com.assosetvous.assosetvous.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name="CLIENT")
@Data
@RequiredArgsConstructor
public class Client implements Serializable {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.AUTO)
	@Column(name = "IDCLIENT")
	private Long id;	
	@Column(name = "NOM")
	private String nom;
	@Column(name = "PRENOM")
	private String prenom;
	@Column(name = "ADRESSE")
	private String adresse;
	@Column(name = "CP")
	private String cp;
	@Column(name = "VILLE")
	private String ville;
	@Column(name = "PAYS")
	private String pays;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="vehicule_id")
	private Vehicule vehicule;
	
	//!! Attention la valeur du  mappedBy doit correspondre à celui présent dans Commande au niveau du ManyToOne
	@OneToMany(mappedBy = "client")
	private List<Commande> commandeList;
	
	@ManyToMany(mappedBy="clientList")
	private List<Location> locationList;
	
	@ManyToMany
	@JoinTable(name="AgenClient")
	private List<Agence> agenceList;

	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="permis_id")
	private PermisDeConduire permisdeconduire;



	
}
