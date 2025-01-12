package com.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medical.entity.Doctor;

@Repository
public interface DocterRepository extends JpaRepository<Doctor,String>{
    
}
