package com.assosetvous.assosetvous.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assosetvous.assosetvous.entity.Camion;
import org.springframework.stereotype.Repository;

@Repository
public interface ICamionRepository extends JpaRepository<Camion, Long> {

}
