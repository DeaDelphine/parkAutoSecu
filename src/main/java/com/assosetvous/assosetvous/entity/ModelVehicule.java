package com.assosetvous.assosetvous.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="MODELEVEHICULE")
@Data
@RequiredArgsConstructor
public class ModelVehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDMODELE")
	private long id;
	@Column(name = "MARQUE")
	private String marque;
	@Column(name = "PRIXJOURNEE")
	private double prixJournee;
	
	@OneToMany(mappedBy = "modelvehicule")
	private List<Vehicule> vehiculeList;

	
	
}
