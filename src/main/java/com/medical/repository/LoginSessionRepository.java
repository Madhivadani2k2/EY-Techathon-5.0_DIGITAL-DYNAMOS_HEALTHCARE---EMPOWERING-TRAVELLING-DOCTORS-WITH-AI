package com.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medical.entity.LoginSession;

@Repository
public interface LoginSessionRepository extends JpaRepository<LoginSession,String>{

    
} 