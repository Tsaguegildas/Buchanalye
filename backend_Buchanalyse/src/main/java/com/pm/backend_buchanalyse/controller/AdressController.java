package com.pm.backend_buchanalyse.controller;

import com.pm.backend_buchanalyse.models.AdressResponse;
import com.pm.backend_buchanalyse.models.AdressRequest;
import com.pm.backend_buchanalyse.service.AdressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/adress")
@AllArgsConstructor

public class AdressController {

    private AdressService adressService;  // injection des dependance pour que le service communique avec le controlleur
    @GetMapping("/{adressId}")
    public ResponseEntity <AdressResponse> getAdress(@PathVariable int adressId){
        return ResponseEntity.ok(adressService.getAdress(adressId));
    }

    @PostMapping
    public ResponseEntity<AdressResponse> addAdress(@Valid @RequestBody AdressRequest adressRequest){
        return ResponseEntity.ok(adressService.addAdress(adressRequest));
    }


}
