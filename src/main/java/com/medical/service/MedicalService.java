package com.medical.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.medical.entity.Doctor;
import com.medical.entity.LoginSession;
import com.medical.entity.PatientSlot;
import com.medical.entity.User;
import com.medical.repository.DocterRepository;
import com.medical.repository.LoginSessionRepository;
import com.medical.repository.PatientRepository;
import com.medical.repository.UserRepository;

@Service
public class MedicalService {
    
    @Autowired
    private UserRepository urepo;
    @Autowired
    private LoginSessionRepository lsrepo;
    @Autowired
    private DocterRepository drepo;
    @Autowired
    private PatientRepository prepo;
    public void save(User u){
        urepo.save(u);
    }

    public boolean checkForAccount(LoginSession ls){
        Optional<User> ou=urepo.findById(ls.getUname());
        
        if (ou.isPresent()) {
            User user = ou.get();
            String pass = user.getPassword();
            if(pass.equals(ls.getPassword())){
                return true;
            }else{
                return false;
            }
       }
        return false;
    }
    public void saveLogin(LoginSession ls){
        lsrepo.save(ls);
    }
    public void registerDoctor(Doctor dr){
        drepo.save(dr);
    }
    public List<Doctor> getAllDoctors(){
        return drepo.findAll();
    }
    public Doctor getDoctorByUserName(String uname){
        return drepo.findById(uname).get();
    }
    public String checkForAppoinment(PatientSlot ps){
        PatientSlot patient = new PatientSlot();                          
        patient.setDuname(ps.getDuname());
        List<PatientSlot> list=prepo.findAll(Example.of(patient)); 
        if(list.size()==0){
            return ps.getTime();
        }      
        else{
            int time=0;
            for(PatientSlot temp:list){
                int t=Integer.parseInt(temp.getTime());
                time=Math.max(time,t);
            }
            return time+"";
        }
    }
    public void bookPatientSlot(PatientSlot ps){
        prepo.save(ps);
    }
    
}
