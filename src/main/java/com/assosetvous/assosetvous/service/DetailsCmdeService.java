package com.assosetvous.assosetvous.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assosetvous.assosetvous.entity.DetailsCmde;
import com.assosetvous.assosetvous.repository.IDetailsCmdeRepository;

@Service
public class DetailsCmdeService {

	@Autowired
	IDetailsCmdeRepository detailscmderepository;
	
	//Liste des cmdeDetails
	
			public List<DetailsCmde> getDetailsCmde(){
				return detailscmderepository.findAll();
			}
			
			//Save
			public DetailsCmde saveDetailsCmde(DetailsCmde detailscmdeservice) {
				return detailscmderepository.save(detailscmdeservice);
			}
			
			//get a DetailsCmdeService
			public DetailsCmde getDetailsCmdeServiceByid(Long idcmdedetail) {
				return detailscmderepository.findById(idcmdedetail).get();
			}
			
			//delete a DetailsCmdeService
			public void deleteDetailsCmdeService(DetailsCmde detailscmdeservice){
				detailscmderepository.delete(detailscmdeservice);
			}
}

