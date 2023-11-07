package com.assosetvous.assosetvous.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assosetvous.assosetvous.entity.Vehicule;
import com.assosetvous.assosetvous.service.VehiculeService;

@RestController
@RequestMapping
@CrossOrigin("*")
public class VehiculeController {
	@Autowired
	VehiculeService vehiculeService;
	
	@PostMapping("/vehicule")
	public Vehicule createVehicule(@Validated @RequestBody(required = false) Vehicule vehicule) {
		return vehiculeService.saveVehicule(vehicule);
	}
	
	@GetMapping("/vehicules")
	public List<Vehicule> getAllVehicules() {
		return vehiculeService.getVehicules();
	}
	
	@GetMapping("/vehicules/{idVehicule}")
	public ResponseEntity getVehiculebyId(@PathVariable(name= "idVehicule") Long idVehicule) {
		if(idVehicule == null) {
			return ResponseEntity.badRequest().body("Canot retreive vehicule with null id");
		}
		Vehicule vehicule1 = vehiculeService.getVehiculeByid(idVehicule);
		if(vehicule1 == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(vehicule1);
	}
	
	@DeleteMapping("/vehicules/{idVehicule}")
	public ResponseEntity<Vehicule> deleteVehicule(@Validated @PathVariable(name= "idVehicule") Long idVehicule) {
		
		Vehicule vehicule1 = vehiculeService.getVehiculeByid(idVehicule);
		if(vehicule1 == null) {
			return ResponseEntity.notFound().build();
		}
		vehiculeService.deleteVehicule(vehicule1); 
		return ResponseEntity.ok().body(vehicule1);
	}
}
