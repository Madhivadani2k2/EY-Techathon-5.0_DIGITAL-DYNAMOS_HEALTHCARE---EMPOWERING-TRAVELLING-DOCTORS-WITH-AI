package com.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medical.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{

    
}