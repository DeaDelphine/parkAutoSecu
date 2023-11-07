package com.assosetvous.assosetvous.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assosetvous.assosetvous.entity.ModelVehicule;
import org.springframework.stereotype.Repository;

@Repository
public interface IModelVehiculeRepository extends JpaRepository<ModelVehicule, Long>  {

}
