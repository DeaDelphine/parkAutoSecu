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
 
import com.assosetvous.assosetvous.entity.Location;
import com.assosetvous.assosetvous.service.LocationService;

@RestController
@RequestMapping
@CrossOrigin("*")
public class LocationController {

	@Autowired
	LocationService locationService;
	
	@PostMapping("/location")
	public Location createLocation(@Validated @RequestBody(required = false) Location location) {
		return locationService.saveLocation(location);
	}
	
	@GetMapping("/locations")
	public List<Location> getAllLocations() {
		return locationService.getLocation();
	}
	
	@GetMapping("/locations/{idlocation}")
	public ResponseEntity getLocationbyId(@PathVariable(name= "idlocation") Long idlocation) {
		if(idlocation == null) {
			return ResponseEntity.badRequest().body("Canot retreive camion with null id");
		}
		Location location1 = locationService.getLocationByid(idlocation);
		if(location1 == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(location1);
	}
	
	@DeleteMapping("/locations/{idlocation}")
	public ResponseEntity<Location> deleteLocation(@Validated @PathVariable(name= "idlocation") Long idlocation) {
		
		Location location1 = locationService.getLocationByid(idlocation);
		if(location1 == null) {
			return ResponseEntity.notFound().build();
		}
		locationService.deleteLocation(location1); 
		return ResponseEntity.ok().body(location1);
	}
}
