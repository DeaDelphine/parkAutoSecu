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

@Getter
@Entity
@Table(name="CLIENT")
@Data
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

	
	
	public Client(String nom, String prenom, String adresse, String cp, String ville, String pays, Vehicule vehicule,
			List<Commande> commandeList, List<Location> locationList, List<Agence> agenceList,
			PermisDeConduire permisdeconduire) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.pays = pays;
		this.vehicule = vehicule;
		this.commandeList = commandeList;
		this.locationList = locationList;
		this.agenceList = agenceList;
		this.permisdeconduire = permisdeconduire;
	}


	public Client(Long id, String nom, String prenom, String adresse, String cp, String ville, String pays,
			Vehicule vehicule, List<Commande> commandeList, List<Location> locationList, List<Agence> agenceList, PermisDeConduire permisdeconduire) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.pays = pays;
		this.vehicule = vehicule;
		this.commandeList = commandeList;
		this.locationList = locationList;
		this.agenceList = agenceList;
		this.permisdeconduire = permisdeconduire;
	}


	public Client() {
		super();
	}


	public void setId(Long id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}


	public void setCommandeList(List<Commande> commandeList) {
		this.commandeList = commandeList;
	}

	public void setLocationList(List<Location> locationList) {
		this.locationList = locationList;
	}

	public void setAgenceList(List<Agence> agenceList) {
		this.agenceList = agenceList;
	}


	public void setPermisdeconduire(PermisDeConduire permisdeconduire) {
		this.permisdeconduire = permisdeconduire;
	}

	
}
