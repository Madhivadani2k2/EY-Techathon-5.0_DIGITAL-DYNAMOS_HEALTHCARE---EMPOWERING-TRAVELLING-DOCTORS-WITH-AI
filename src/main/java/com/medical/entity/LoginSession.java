package com.medical.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LoginSession {
    @Id
    String uname;
    String password;
    public LoginSession(){
        super();
    }
    public LoginSession(String uname,String password){
        this.uname=uname;
        this.password=password;
    }
    
}
