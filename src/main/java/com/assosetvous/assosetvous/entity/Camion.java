package com.assosetvous.assosetvous.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="CAMION")
@Data
@RequiredArgsConstructor

public class Camion extends Vehicule{
	
	@Override
	public String demarrer() {
		return "VRROOOOOMMMM!";
	}
	
	@Override
	public String accelerer() {
		return "RRRRRRRRRRR!";
	}
	//Constructeur par défaut

}
