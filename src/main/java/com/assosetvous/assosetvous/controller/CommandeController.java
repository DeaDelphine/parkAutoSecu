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

import com.assosetvous.assosetvous.entity.Commande;
import com.assosetvous.assosetvous.service.CommandeService;

@RestController
@RequestMapping
@CrossOrigin("*")
public class CommandeController {
	@Autowired
	CommandeService commandeService;
	
	@PostMapping("/commande")
	public Commande createCommande(@Validated @RequestBody(required = false) Commande commande) {
		return commandeService.saveCommande(commande);
	}
	
	@GetMapping("/commandes")
	public List<Commande> getAllCommandes() {
		return commandeService.getCommande();
	}
	
	@GetMapping("/commandes/{idcommande}")
	public ResponseEntity getCommandebyId(@PathVariable(name= "idcommande") Long idcommande) {
		if(idcommande == null) {
			return ResponseEntity.badRequest().body("Canot retreive commande with null id");
		}
		Commande commande1 = commandeService.getCommandeByid(idcommande);
		if(commande1 == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(commande1);
	}
	
	@DeleteMapping("/commandes/{idcommande}")
	public ResponseEntity<Commande> deletecommande(@Validated @PathVariable(name= "idcommande") Long idcommande) {
		
		Commande commande1 = commandeService.getCommandeByid(idcommande);
		if(commande1 == null) {
			return ResponseEntity.notFound().build();
		}
		commandeService.deleteCommande(commande1); 
		return ResponseEntity.ok().body(commande1);
	}
}
