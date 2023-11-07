package com.assosetvous.assosetvous.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assosetvous.assosetvous.entity.DetailsCmde;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetailsCmdeRepository extends JpaRepository<DetailsCmde, Long> {

}
