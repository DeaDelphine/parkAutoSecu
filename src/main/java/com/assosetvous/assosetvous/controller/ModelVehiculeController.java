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

import com.assosetvous.assosetvous.entity.ModelVehicule;
import com.assosetvous.assosetvous.service.ModelVehiculeService;


@RestController
@RequestMapping
@CrossOrigin("*")
public class ModelVehiculeController {

	@Autowired
	ModelVehiculeService modelService;
	
	@PostMapping("/model")
	public ModelVehicule createModelVehicule(@Validated @RequestBody(required = false) ModelVehicule model) {
		return modelService.saveModelVehicule(model);
	}
	
	@GetMapping("/models")
	public List<ModelVehicule> getAllModelVehicules() {
		return modelService.getModelVehicule();
	}
	
	@GetMapping("/models/{idmodel}")
	public ResponseEntity getModelVehiculebyId(@PathVariable(name= "idmodel") Long idmodel) {
		if(idmodel == null) {
			return ResponseEntity.badRequest().body("Canot retreive camion with null id");
		}
		ModelVehicule model1 = modelService.getModelVehiculeByid(idmodel);
		if(model1 == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(model1);
	}
	
	@DeleteMapping("/models/{idmodel}")
	public ResponseEntity<ModelVehicule> deleteModelVehicule(@Validated @PathVariable(name= "idmodel") Long idmodel) {
		
		ModelVehicule model1 = modelService.getModelVehiculeByid(idmodel);
		if(model1 == null) {
			return ResponseEntity.notFound().build();
		}
		modelService.deleteModelVehicule(model1); 
		return ResponseEntity.ok().body(model1);
	}
}
