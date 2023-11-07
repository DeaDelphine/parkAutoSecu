package com.assosetvous.assosetvous.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assosetvous.assosetvous.entity.Agence;
import com.assosetvous.assosetvous.repository.IAgenceRepository;


@Service
public class AgenceService {

	@Autowired
	IAgenceRepository agenceRepository;
	
	//Liste des Agences
	
		public List<Agence> getAgence(){
			return agenceRepository.findAll();
		}
		
		//Save
		public Agence saveAgence(Agence agence) {
			return agenceRepository.save(agence);
		}
		
		//get a Agence
		public Agence getAgenceByid(Long idagence) {
			return agenceRepository.findById(idagence).get();
		}
		
		//delete a Agence
		public void deleteAgence(Agence agence){
			agenceRepository.delete(agence);
		}
}
