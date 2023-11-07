package com.assosetvous.assosetvous.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assosetvous.assosetvous.entity.Vehicule;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehiculeRepository extends JpaRepository<Vehicule, Long>{

	

}
