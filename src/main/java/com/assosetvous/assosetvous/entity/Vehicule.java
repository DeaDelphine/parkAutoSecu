package com.assosetvous.assosetvous.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="vehicule")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@RequiredArgsConstructor
public class Vehicule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDVEHICULE")
	private long id;
	
	@Column(name = "ANNEEMODEL")
	private int anneeModel;
	
	@Column(name = "PRIX")
	private double prix;

	 @Column(name="IMAGEVEHICULE")
	 private String imageVehicule;
	@Column(name = "DESCRIPTIF")
	private String descriptif;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="LocatVehicule")
	private List<Location> locationList;
	@JsonIgnore
	@ManyToMany(mappedBy="vehiculeList")
	private List<Agence> agenceList;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="modelvehicule_id")
	private ModelVehicule modelvehicule;

	@JsonIgnore
	@OneToMany(mappedBy = "vehicule")
	private List<Image> imagesList;



	@Override
	public String toString() {
		return "Véhicule [id=" + id + ", anneeModel=" + anneeModel + ", prix=" + prix + "]";
	}
	
	public String demarrer() {
		return "Véhicule démarré !!";
	}

	public String accelerer() {
		return "Véhicule accelère !!";
	}
}
