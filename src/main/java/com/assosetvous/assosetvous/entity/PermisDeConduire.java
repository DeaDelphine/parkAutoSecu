package com.assosetvous.assosetvous.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="PERMISDECONDUIRE")
@Data
@RequiredArgsConstructor
public class PermisDeConduire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDPERMIS")
	private long id;
	@Column(name = "NUMEROPERMIS")
	private String numeroPermis;
	@Column(name = "DATEOBTENTION")
	private String dateObtention;

	
	
}
