package com.pm.backend_buchanalyse.service;

import com.pm.backend_buchanalyse.dto.UserResponse;
import com.pm.backend_buchanalyse.models.Adress;
import com.pm.backend_buchanalyse.dto.AdressRequest;
import com.pm.backend_buchanalyse.repository.AdressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdressService {
    private AdressRepository adressRepository;

    public UserResponse.AdressResponse getAdress(int adressId) {
        Adress adress = this.adressRepository.findById(adressId)
                .orElseThrow(() -> new RuntimeException("Adress not found"));
        UserResponse.AdressResponse adressRes = new UserResponse.AdressResponse();

        adressRes.setLand(adress.getLand());
        adressRes.setStadt(adress.getStadt());
        adressRes.setPostleizahl(adress.getPostleizahl());
        adressRes.setHausnummer(adress.getHausnummer());
        adressRes.setCreatedAt(adress.getCreatedAt());
        adressRes.setUpdateAt(adress.getUpdateAt());
        adressRes.setId(adress.getId());

        return adressRes;
    }

    public UserResponse.AdressResponse addAdress(AdressRequest adressRequest) {
        Adress adress= new Adress();
        adress.setLand(adressRequest.getLand());
        adress.setStadt(adressRequest.getStadt());
        adress.setHausnummer(adressRequest.getHausnummer());
        adress.setPostleizahl(adressRequest.getPostleizahl());

        Adress adressSaved = this.adressRepository.save(adress);
        UserResponse.AdressResponse adressResponse = new UserResponse.AdressResponse();

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
