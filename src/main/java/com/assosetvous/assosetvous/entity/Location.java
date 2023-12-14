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
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="LOCATION")
@Data
@RequiredArgsConstructor
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

	
}
