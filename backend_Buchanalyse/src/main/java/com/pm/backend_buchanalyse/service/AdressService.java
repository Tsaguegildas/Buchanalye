package com.pm.backend_buchanalyse.service;

import com.pm.backend_buchanalyse.dto.AdressResponse;
import com.pm.backend_buchanalyse.dto.UserResponse;
import com.pm.backend_buchanalyse.models.Adress;
import com.pm.backend_buchanalyse.dto.AdressRequest;
import com.pm.backend_buchanalyse.repository.AdressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdressService {
    private AdressRepository adressRepository;

    public AdressResponse getAdress(int adressId) {
        Adress adress = this.adressRepository.findById(adressId)
                .orElseThrow(() -> new RuntimeException("Adress not found"));
        AdressResponse adressRes = new AdressResponse();

        adressRes.setLand(adress.getLand());
        adressRes.setStadt(adress.getStadt());
        adressRes.setPostleizahl(adress.getPostleizahl());
        adressRes.setHausnummer(adress.getHausnummer());
        adressRes.setCreatedAt(adress.getCreatedAt());
        adressRes.setUpdateAt(adress.getUpdateAt());
        adressRes.setId(adress.getId());

        return adressRes;
    }

    public AdressResponse addAdress(AdressRequest adressRequest) {
        Adress adress= new Adress();
        adress.setLand(adressRequest.getLand());
        adress.setStadt(adressRequest.getStadt());
        adress.setHausnummer(adressRequest.getHausnummer());
        adress.setPostleizahl(adressRequest.getPostleizahl());

        Adress adressSaved = this.adressRepository.save(adress);
        AdressResponse adressResponse = new AdressResponse();

        adressResponse.setId(adressSaved.getId());
        adressResponse.setLand(adressSaved.getLand());
        adressResponse.setStadt(adressSaved.getStadt());
        adressResponse.setHausnummer(adressSaved.getHausnummer());
        adressResponse.setPostleizahl(adressSaved.getPostleizahl());
        adressResponse.setCreatedAt(adressSaved.getCreatedAt());
        adressResponse.setUpdateAt(adressSaved.getUpdateAt());


        return adressResponse;
    }

    public List<Adress> getAllAdress() {
        return adressRepository.findAll().
                stream().map( adress -> {
                    Adress adress1= new Adress();
                    adress1.setHausnummer(adress.getHausnummer());
                    adress1.setPostleizahl(adress.getPostleizahl());
                    adress1.setId(adress.getId());
                    adress1.setStadt(adress.getStadt());
                    adress1.setCreatedAt(adress.getCreatedAt());
                    adress1.setUpdateAt(adress.getUpdateAt());
                    adress1.setLand(adress.getLand());
                    return adress1;
                }).toList();
    }
}
