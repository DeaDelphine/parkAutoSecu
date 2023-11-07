package com.assosetvous.assosetvous.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assosetvous.assosetvous.entity.Voiture;
import com.assosetvous.assosetvous.repository.IVoitureRepository;

@Service
public class VoitureService {

	@Autowired
	IVoitureRepository voitureRepository;
	
	//Liste des Voitures
	
			public List<Voiture> getVoiture(){
				return voitureRepository.findAll();
			}
			
			//Save
			public Voiture saveVoiture(Voiture voiture) {
				return voitureRepository.save(voiture);
			}
			
			//get a Camion
			public Voiture getVoitureByid(Long idcam) {
				return voitureRepository.findById(idcam).get();
			}
			
			//delete a Camion
			public void deleteVoiture(Voiture voiture){
				voitureRepository.delete(voiture);
			}
		
}
