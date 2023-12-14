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
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="AGENCE")
@Data
@RequiredArgsConstructor
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

	
	
}
