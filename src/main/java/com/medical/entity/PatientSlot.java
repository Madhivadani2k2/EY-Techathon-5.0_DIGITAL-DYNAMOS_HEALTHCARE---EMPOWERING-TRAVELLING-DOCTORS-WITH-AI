package com.medical.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PatientSlot {
    
    @Id
    String uname;
    String duname;
    String patientName;
    String date;
    String time;
    String symptom;
    public PatientSlot(){
        super();
    }
    public PatientSlot(String duname,String patientName,String date,String time,String uname,String symptom){

        this.duname=duname;
        this.patientName=patientName;
        this.date=date;
        this.time=time;
        this.uname=uname;
        this.symptom=symptom;
    }
}
