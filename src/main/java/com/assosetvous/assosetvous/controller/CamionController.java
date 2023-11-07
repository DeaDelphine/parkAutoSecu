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

import com.assosetvous.assosetvous.entity.Camion;
import com.assosetvous.assosetvous.service.CamionService;


@RestController
@RequestMapping
@CrossOrigin("*")
public class CamionController {

	@Autowired
	CamionService camionService;
	
	@PostMapping("/camion")
	public Camion createcamion(@Validated @RequestBody(required = false) Camion camion) {
		return camionService.saveCamion(camion);
	}
	
	@GetMapping("/camions")
	public List<Camion> getAllcamions() {
		return camionService.getCamion();
	}
	
	@GetMapping("/camions/{idcamion}")
	public ResponseEntity getcamionbyId(@PathVariable(name= "idcamion") Long idcamion) {
		if(idcamion == null) {
			return ResponseEntity.badRequest().body("Canot retreive camion with null id");
		}
		Camion camion1 = camionService.getCamionByid(idcamion);
		if(camion1 == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(camion1);
	}
	
	@DeleteMapping("/camions/{idcamion}")
	public ResponseEntity<Camion> deletecamion(@Validated @PathVariable(name= "idcamion") Long idcamion) {
		
		Camion camion1 = camionService.getCamionByid(idcamion);
		if(camion1 == null) {
			return ResponseEntity.notFound().build();
		}
		camionService.deleteCamion(camion1); 
		return ResponseEntity.ok().body(camion1);
	}
}
