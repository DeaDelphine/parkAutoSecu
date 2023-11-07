package com.assosetvous.assosetvous.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.assosetvous.assosetvous.entity.Commande;
import com.assosetvous.assosetvous.repository.ICommandeRepository;

@Service
public class CommandeService {
	@Autowired
	ICommandeRepository commandeRepository;
	
	//Liste des commandes
	
		public List<Commande> getCommande(){
			return commandeRepository.findAll();
		}
		
		//Save
		public Commande saveCommande(Commande commande) {
			return commandeRepository.save(commande);
		}
		
		//get a Camion
		public Commande getCommandeByid(Long idcomm) {
			return commandeRepository.findById(idcomm).get();
		}
		
		//delete a Camion
		public void deleteCommande(Commande commande){
			commandeRepository.delete(commande);
		}
	
}
