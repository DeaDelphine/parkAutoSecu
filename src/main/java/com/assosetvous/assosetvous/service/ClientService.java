package com.assosetvous.assosetvous.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assosetvous.assosetvous.entity.Client;
import com.assosetvous.assosetvous.repository.IClientRepository;


@Service
public class ClientService {
	@Autowired
	IClientRepository clientRepository;
	
	//Liste de Client
	
	public List<Client> getClient(){
		return clientRepository.findAll();
	}
	
	//Save a client
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}
	
	//get a Client
	public Client getClientByid(Long idcli) {
		return clientRepository.findById(idcli).get();
	}
	
	//delete a Client
	public void deleteClient(Client client){
		clientRepository.delete(client);
	}
}
