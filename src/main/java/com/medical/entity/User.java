
package com.medical.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User{

    @Id
    String uName;
    String name;
    String city;
    String email;
    String password;
    String password2;
    public User(String uName,String name,String city,String email,String password,String password2){
        this.city=city;
        this.email=email;
        this.name=name;
        this.uName=uName;
        this.password=password;
        this.password2=password2;
    }
    public User(){
        super();
    }

}