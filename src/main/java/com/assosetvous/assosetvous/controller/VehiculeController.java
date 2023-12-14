package com.assosetvous.assosetvous.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

	@PutMapping("/vehicules/{idVehicule}")
	public ResponseEntity updatedVehiculeById(@Validated @RequestBody Vehicule vehicule, @PathVariable(name= "idVehicule") Long idVehicule){
		if(idVehicule == null) {
			return ResponseEntity.badRequest().body("Canot retreive vehicule with null id");
		}
		Vehicule vehicule1 = vehiculeService.getVehiculeByid(idVehicule);
		vehicule1.setDescriptif(vehicule.getDescriptif());
		vehicule1.setAnneeModel(vehicule.getAnneeModel());
		vehicule1.setPrix(vehicule.getPrix());
		vehicule1.setImageVehicule(vehicule.getImageVehicule());
		vehiculeService.updatedVehiculeById(vehicule1);
		return  ResponseEntity.ok().body(vehicule1);
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
