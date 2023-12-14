package com.assosetvous.assosetvous.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assosetvous.assosetvous.entity.Vehicule;
import com.assosetvous.assosetvous.repository.IVehiculeRepository;

@Service
public class VehiculeService {
	@Autowired
	IVehiculeRepository vehiculeRepository;
	
	//Liste de véhicules
	
	public List<Vehicule> getVehicules(){
		return vehiculeRepository.findAll();
	}
	
	//Save
	public Vehicule saveVehicule(Vehicule vehicule) {
		return vehiculeRepository.save(vehicule);
	}
	
	//get a Vehicule
	public Vehicule getVehiculeByid(Long idvehi) {
		return vehiculeRepository.findById(idvehi).get();
	}

	//put a Vehicule
	public Vehicule updatedVehiculeById(Vehicule vehicule){
		return vehiculeRepository.save(vehicule);
	}
	
	//delete a Vehicule
	public void deleteVehicule(Vehicule vehicule){
		vehiculeRepository.delete(vehicule);
	}
}
