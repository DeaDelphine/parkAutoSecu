package com.assosetvous.assosetvous.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assosetvous.assosetvous.entity.Camion;
import com.assosetvous.assosetvous.repository.ICamionRepository;

@Service
public class CamionService {

	@Autowired
	ICamionRepository camionRepository;
	
	//Liste des Camions
	
		public List<Camion> getCamion(){
			return camionRepository.findAll();
		}
		
		//Save
		public Camion saveCamion(Camion camion) {
			return camionRepository.save(camion);
		}
		
		//get a Camion
		public Camion getCamionByid(Long idcam) {
			return camionRepository.findById(idcam).get();
		}
		
		//delete a Camion
		public void deleteCamion(Camion camion){
			camionRepository.delete(camion);
		}
	
}
