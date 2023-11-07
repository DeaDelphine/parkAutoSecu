package com.assosetvous.assosetvous.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assosetvous.assosetvous.entity.Voiture;
import org.springframework.stereotype.Repository;

@Repository
public interface IVoitureRepository extends JpaRepository<Voiture, Long> {

}
