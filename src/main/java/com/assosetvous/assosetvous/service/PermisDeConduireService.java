package com.assosetvous.assosetvous.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assosetvous.assosetvous.entity.PermisDeConduire;
import com.assosetvous.assosetvous.repository.IPermisDeConduire;

@Service
public class PermisDeConduireService {

	@Autowired
	IPermisDeConduire permisRepository;
	
	//Liste des PermisDeConduires
	
		public List<PermisDeConduire> getPermisDeConduire(){
			return permisRepository.findAll();
		}
		
		//Save
		public PermisDeConduire savePermisDeConduire(PermisDeConduire permis) {
			return permisRepository.save(permis);
		}
		
		//get a PermisDeConduire
		public PermisDeConduire getPermisDeConduireByid(Long idpermis) {
			return permisRepository.findById(idpermis).get();
		}
		
		//delete a PermisDeConduire
		public void deletePermisDeConduire(PermisDeConduire permis){
			permisRepository.delete(permis);
		}
}
