package com.medical.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Doctor {
    @Id
    String uname;
    String name;
    String cname;
    String email;
    String password;
    String city;
    String address;
    String start;
    String end;
    public Doctor(String uname,String name,String email,String password,String cname,String city,String address,String start,String end){
        this.name=name;
        this.uname=uname;
        this.email=email;
        this.cname=cname;
        this.city=city;
        this.address=address;
        this.password=password;
        this.start=start;
        this.end=end;
    }
    public Doctor(){
        super();
    }
}
