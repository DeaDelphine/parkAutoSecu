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

import com.assosetvous.assosetvous.entity.Voiture;
import com.assosetvous.assosetvous.service.VoitureService;

@RestController
@RequestMapping
@CrossOrigin("*")
public class VoitureController {

	@Autowired
	VoitureService voitureService;
	
	@PostMapping("/voiture")
	public Voiture createvoiture(@Validated @RequestBody(required = false) Voiture voiture) {
		return voitureService.saveVoiture(voiture);
	}
	
	@GetMapping("/voitures")
	public List<Voiture> getAllvoitures() {
		return voitureService.getVoiture();
	}
	
	@GetMapping("/voitures/{idvoiture}")
	public ResponseEntity getvoiturebyId(@PathVariable(name= "idvoiture") Long idvoiture) {
		if(idvoiture == null) {
			return ResponseEntity.badRequest().body("Canot retreive voiture with null id");
		}
		Voiture voiture1 = voitureService.getVoitureByid(idvoiture);
		if(voiture1 == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(voiture1);
	}
	
	@DeleteMapping("/voitures/{idvoiture}")
	public ResponseEntity<Voiture> deletevoiture(@Validated @PathVariable(name= "idvoiture") Long idvoiture) {
		
		Voiture voiture1 = voitureService.getVoitureByid(idvoiture);
		if(voiture1 == null) {
			return ResponseEntity.notFound().build();
		}
		voitureService.deleteVoiture(voiture1); 
		return ResponseEntity.ok().body(voiture1);
	}
}
