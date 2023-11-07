package com.assosetvous.assosetvous.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assosetvous.assosetvous.entity.ModelVehicule;
import com.assosetvous.assosetvous.repository.IModelVehiculeRepository;

@Service
public class ModelVehiculeService {

	@Autowired
	IModelVehiculeRepository modelvehiculeRepository;
	
	//Liste des ModelVehicules
	
		public List<ModelVehicule> getModelVehicule(){
			return modelvehiculeRepository.findAll();
		}
		
		//Save
		public ModelVehicule saveModelVehicule(ModelVehicule modelvehicule) {
			return modelvehiculeRepository.save(modelvehicule);
		}
		
		//get a ModelVehicule
		public ModelVehicule getModelVehiculeByid(Long idmodel) {
			return modelvehiculeRepository.findById(idmodel).get();
		}
		
		//delete a ModelVehicule
		public void deleteModelVehicule(ModelVehicule modelvehicule){
			modelvehiculeRepository.delete(modelvehicule);
		}
}
