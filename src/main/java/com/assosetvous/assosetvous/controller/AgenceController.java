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

import com.assosetvous.assosetvous.entity.Agence;
import com.assosetvous.assosetvous.service.AgenceService;



@RestController
@RequestMapping
@CrossOrigin("*")
public class AgenceController {

	@Autowired
	AgenceService agenceService;
	
	@PostMapping("/agence")
	public Agence createAgence(@Validated @RequestBody(required = false) Agence agence) {
		return agenceService.saveAgence(agence);
	}
	
	@GetMapping("/agences")
	public List<Agence> getAllAgences() {
		return agenceService.getAgence();
	}
	
	@GetMapping("/agences/{idagence}")
	public ResponseEntity getAgencebyId(@PathVariable(name= "idagence") Long idagence) {
		if(idagence == null) {
			return ResponseEntity.badRequest().body("Canot retreive agence with null id");
		}
		Agence agence1 = agenceService.getAgenceByid(idagence);
		if(agence1 == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(agence1);
	}
	
	@DeleteMapping("/agences/{idagence}")
	public ResponseEntity<Agence> deleteAgence(@Validated @PathVariable(name= "idagence") Long idagence) {
		
		Agence agence1 = agenceService.getAgenceByid(idagence);
		if(agence1 == null) {
			return ResponseEntity.notFound().build();
		}
		agenceService.deleteAgence(agence1); 
		return ResponseEntity.ok().body(agence1);
	}
}
