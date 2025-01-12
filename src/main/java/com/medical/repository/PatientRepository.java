package com.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medical.entity.PatientSlot;

@Repository
public interface PatientRepository extends JpaRepository<PatientSlot,String>{
    
}
