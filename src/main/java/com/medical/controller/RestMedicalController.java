package com.medical.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestMedicalController {
    @GetMapping("/predict")
    public String getSquare( String str) {
        String apiUrl = "http://127.0.0.1:5000/";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        System.out.print(response);
        // You can process the response further if needed
        return "/";
    }
}
