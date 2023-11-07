package com.assosetvous.assosetvous.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="VOITURE")
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


	public Voiture(String media, String immatriculation, String puissanceFiscale, String categorie, int nbPorte,
			int poidsTotal) {
		super();
		this.media = media;
		this.immatriculation = immatriculation;
		this.puissanceFiscale = puissanceFiscale;
		this.categorie = categorie;
		this.nbPorte = nbPorte;
		this.poidsTotal = poidsTotal;
	}
	public Voiture() {
		super();	
	}

	
	
	public Voiture(int anneeModel, double prix, List<Location> locationList, List<Agence> agenceList,
			ModelVehicule modelvehicule) {
		super(anneeModel, prix, locationList, agenceList, modelvehicule);
		// TODO Auto-generated constructor stub
	}
	public Voiture(long id, int anneeModel, double prix, List<Location> locationList, List<Agence> agenceList,
			ModelVehicule modelvehicule) {
		super(id, anneeModel, prix, locationList, agenceList, modelvehicule);
		// TODO Auto-generated constructor stub
	}
	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getPuissanceFiscale() {
		return puissanceFiscale;
	}

	public void setPuissanceFiscale(String puissanceFiscale) {
		this.puissanceFiscale = puissanceFiscale;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public int getNbPorte() {
		return nbPorte;
	}

	public void setNbPorte(int nbPorte) {
		this.nbPorte = nbPorte;
	}

	public int getPoidsTotal() {
		return poidsTotal;
	}

	public void setPoidsTotal(int poidsTotal) {
		this.poidsTotal = poidsTotal;
	}
	
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
