package com.assosetvous.assosetvous.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assosetvous.assosetvous.entity.Location;
import com.assosetvous.assosetvous.repository.ILocationRepository;


@Service
public class LocationService {
	@Autowired
	ILocationRepository locationRepository;
	
	//Liste des Locations
	
		public List<Location> getLocation(){
			return locationRepository.findAll();
		}
		
		//Save
		public Location saveLocation(Location location) {
			return locationRepository.save(location);
		}
		
		//get a Camion
		public Location getLocationByid(Long idloc) {
			return locationRepository.findById(idloc).get();
		}
		
		//delete a Camion
		public void deleteLocation(Location location){
			locationRepository.delete(location);
		}
	
}
