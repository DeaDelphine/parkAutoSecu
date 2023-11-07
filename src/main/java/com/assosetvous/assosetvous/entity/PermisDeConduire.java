package com.assosetvous.assosetvous.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PERMISDECONDUIRE")
public class PermisDeConduire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDPERMIS")
	private long id;
	@Column(name = "NUMEROPERMIS")
	private String numeroPermis;
	@Column(name = "DATEOBTENTION")
	private String dateObtention;
	
	
	public PermisDeConduire(String numeroPermis, String dateObtention) {
		super();
		this.numeroPermis = numeroPermis;
		this.dateObtention = dateObtention;
	}


	public PermisDeConduire(long id, String numeroPermis, String dateObtention) {
		super();
		this.id = id;
		this.numeroPermis = numeroPermis;
		this.dateObtention = dateObtention;
	}


	public PermisDeConduire() {
		super();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNumeroPermis() {
		return numeroPermis;
	}


	public void setNumeroPermis(String numeroPermis) {
		this.numeroPermis = numeroPermis;
	}


	public String getDateObtention() {
		return dateObtention;
	}


	public void setDateObtention(String dateObtention) {
		this.dateObtention = dateObtention;
	}

	
	
}
