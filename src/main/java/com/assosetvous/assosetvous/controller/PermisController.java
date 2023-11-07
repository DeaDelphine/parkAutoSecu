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

import com.assosetvous.assosetvous.entity.PermisDeConduire;
import com.assosetvous.assosetvous.service.PermisDeConduireService;


@RestController
@RequestMapping
@CrossOrigin("*")
public class PermisController {

	@Autowired
	PermisDeConduireService permisService;
	
	@PostMapping("/permis")
	public PermisDeConduire createPermisDeConduire(@Validated @RequestBody(required = false) PermisDeConduire permis) {
		return permisService.savePermisDeConduire(permis);
	}
	
	@GetMapping("/permis")
	public List<PermisDeConduire> getAllPermisDeConduires() {
		return permisService.getPermisDeConduire();
	}
	
	@GetMapping("/permis/{idpermis}")
	public ResponseEntity getPermisDeConduirebyId(@PathVariable(name= "idpermis") Long idpermis) {
		if(idpermis == null) {
			return ResponseEntity.badRequest().body("Canot retreive camion with null id");
		}
		PermisDeConduire permis1 = permisService.getPermisDeConduireByid(idpermis);
		if(permis1 == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(permis1);
	}
	
	@DeleteMapping("/permis/{idpermis}")
	public ResponseEntity<PermisDeConduire> deletePermisDeConduire(@Validated @PathVariable(name= "idpermis") Long idpermis) {
		
		PermisDeConduire permis1 = permisService.getPermisDeConduireByid(idpermis);
		if(permis1 == null) {
			return ResponseEntity.notFound().build();
		}
		permisService.deletePermisDeConduire(permis1); 
		return ResponseEntity.ok().body(permis1);
	}
}
