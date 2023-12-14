package com.assosetvous.assosetvous.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="VOITURE")
@Data
@RequiredArgsConstructor
public class Voiture extends Vehicule{
	
	@Column(name = "MEDIA")
	private String media;
	@Column(name = "IMMAT")
	private String immatriculation;
	@Column(name = "PFISCALE")
	private String puissanceFiscale;
	@Column(name = "CATEGORIE")
	private String categorie;
	@Column(name = "NBPORTE")
	private int nbPorte;
	@Column(name = "POIDSTOTAL")
	private int poidsTotal;


	@Override
	public String toString() {
		return "Voiture [media=" + media + ", immatriculation=" + immatriculation + ", puissanceFiscale=" + puissanceFiscale + "]";
	}
	
	public String demarrer() {
		return "Voiture démarré !!";
	}
	
	


	public String accelerer() {
		return "Voiture accelère !!";
	}

}
