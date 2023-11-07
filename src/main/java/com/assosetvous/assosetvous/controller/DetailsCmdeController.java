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


import com.assosetvous.assosetvous.entity.DetailsCmde;
import com.assosetvous.assosetvous.service.DetailsCmdeService;

@RestController
@RequestMapping
@CrossOrigin("*")
public class DetailsCmdeController {

	@Autowired
	DetailsCmdeService detailcmdeService;
	
	@PostMapping("/detailscmde")
	public DetailsCmde createdetailscmde(@Validated @RequestBody(required = false) DetailsCmde cmdedetails) {
		return detailcmdeService.saveDetailsCmde(cmdedetails);
	}
	
	@GetMapping("/detailscmdes")
	public List<DetailsCmde> getAllcmdedetails() {
		return detailcmdeService.getDetailsCmde();
	}
	
	@GetMapping("/detailscmdes/{idcmdedetails}")
	public ResponseEntity getcmdedetailsbyId(@PathVariable(name= "idcmdedetails") Long idcmdedetails) {
		if(idcmdedetails == null) {
			return ResponseEntity.badRequest().body("Canot retreive cmdedetails with null id");
		}
		DetailsCmde detailscmdes1 = detailcmdeService.getDetailsCmdeServiceByid(idcmdedetails);
		if(detailscmdes1 == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(detailscmdes1);
	}
	
	@DeleteMapping("/detailscmdes/{idcmdedetails}")
	public ResponseEntity<DetailsCmde> deletecmdedetails(@Validated @PathVariable(name= "idcamion") Long idcmdedetails) {
		
		DetailsCmde detailscmdes1 = detailcmdeService.getDetailsCmdeServiceByid(idcmdedetails);
		if(detailscmdes1 == null) {
			return ResponseEntity.notFound().build();
		}
		detailcmdeService.deleteDetailsCmdeService(detailscmdes1); 
		return ResponseEntity.ok().body(detailscmdes1);
	}
}
