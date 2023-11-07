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

import com.assosetvous.assosetvous.entity.Client;
import com.assosetvous.assosetvous.service.ClientService;


@RestController
@RequestMapping
@CrossOrigin("*")
public class ClientController {
	@Autowired
	ClientService clientService;
	
	//je rajoute un truc
	@PostMapping("/client")
	public Client createClient(@Validated @RequestBody(required = false) Client client) {
		return clientService.saveClient(client);
	}
	
	@GetMapping("/clients")
	public List<Client> getAllClients() {
		return clientService.getClient();
	}
	
	@GetMapping("/clients/{idClient}")
	public ResponseEntity getClientbyId(@PathVariable(name= "idClient") Long idClient) {
		if(idClient == null) {
			return ResponseEntity.badRequest().body("Canot retreive client with null id");
		}
		Client client1 = clientService.getClientByid(idClient);
		if(client1 == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(client1);
	}
	
	@DeleteMapping("/clients/{idClient}")
	public ResponseEntity<Client> deleteClient(@Validated @PathVariable(name= "idClient") Long idClient) {
		
		Client client1 = clientService.getClientByid(idClient);
		if(client1 == null) {
			return ResponseEntity.notFound().build();
		}
		clientService.deleteClient(client1); 
		return ResponseEntity.ok().body(client1);
	}
}
