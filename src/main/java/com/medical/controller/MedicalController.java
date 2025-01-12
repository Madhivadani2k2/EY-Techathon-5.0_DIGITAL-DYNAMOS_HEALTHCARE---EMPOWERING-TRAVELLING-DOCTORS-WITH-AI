package com.medical.controller;

import java.util.List;

import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.medical.entity.Doctor;
import com.medical.entity.LoginSession;
import com.medical.entity.PatientSlot;
import com.medical.entity.User;
import com.medical.service.MedicalService;



@Controller
public class MedicalController {
    
    @Autowired
    private MedicalService service;

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/get-sign-up-form")
    public String getSignUpForm() {
        return "signup";
    }
    
    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute User user) {
        service.save(user);
        return "redirect:/";
    }
    
    @GetMapping("/get-login-form")
    public String getLoginForm(){
        return "login";
    }
/* 
    @GetMapping("/available-books")
    public ModelAndView availableBooks(){
        List<Books> list=service.getAllBooks();
        return new ModelAndView("availableBooks","books",list);
    }*/

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute LoginSession ls){
        boolean bl=service.checkForAccount(ls);
        if(bl){
            //service.saveLogin(ls);
            return new ModelAndView("user-home","user",ls);
        }else{
            String str="Invalid Username or Password";
            return new ModelAndView("wrong-account","msg",str);
        }
       
    }
    @GetMapping("/get-docter-registration-form")
    public String getDoctorRegistrationForm() {
        return "doctor-registration";
    }
    

    @PostMapping("/register-doctor")
    public String doctorRegister(@ModelAttribute Doctor dr) {
        service.registerDoctor(dr);
        return "redirect:/doctors";
    }
    @GetMapping("/doctors")
    public ModelAndView doctors() {
        List<Doctor> list=service.getAllDoctors();

        return new ModelAndView("doctor","doctors",list);
    }
    @GetMapping("/application-form/{duname}")
    public ModelAndView getMethodName(@PathVariable String duname) {
        Doctor d=service.getDoctorByUserName(duname);
        return new ModelAndView("form","doctor",d);
    }
     
    @PostMapping("/book-doctor")
    public ModelAndView bookDoctor(@ModelAttribute PatientSlot ps) {
        String str=service.checkForAppoinment(ps);
        ps.setTime(str);
        service.bookPatientSlot(ps);
        Doctor dd=service.getDoctorByUserName(ps.getDuname());
        return new ModelAndView("success","appointment",dd);
    }

    @GetMapping("/greet")
    public String getGreet() {
        try (PythonInterpreter interpreter = new PythonInterpreter()) {
            interpreter.execfile("Django/medical/api.py");
        }
        return "redirect:/";
    }
    
    
}
