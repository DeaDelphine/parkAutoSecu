package com.assosetvous.assosetvous.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assosetvous.assosetvous.entity.PermisDeConduire;
import org.springframework.stereotype.Repository;

@Repository
public interface IPermisDeConduire extends JpaRepository<PermisDeConduire, Long>  {

}
