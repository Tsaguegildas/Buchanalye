package com.pm.backend_buchanalyse.service;

import com.pm.backend_buchanalyse.models.Adress;
import com.pm.backend_buchanalyse.models.AdressRequest;
import com.pm.backend_buchanalyse.models.AdressResponse;
import com.pm.backend_buchanalyse.repository.AdressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

        adressResponse.setId(adressResponse.getId());
        adressResponse.setLand(adressSaved.getLand());
        adressResponse.setStadt(adressSaved.getStadt());
        adressResponse.setHausnummer(adressSaved.getHausnummer());
        adressResponse.setPostleizahl(adressSaved.getPostleizahl());
        adressResponse.setCreatedAt(adressSaved.getCreatedAt());
        adressResponse.setUpdateAt(adressSaved.getUpdateAt());


        return adressResponse;
    }
}
