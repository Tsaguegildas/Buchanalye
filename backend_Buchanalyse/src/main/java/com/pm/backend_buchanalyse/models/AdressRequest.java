package com.pm.backend_buchanalyse.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
public class AdressRequest {
    @NotBlank(message= "Land ist erforderlich")
    private String land;
    @NotBlank(message= "Stadt ist erforderlich")
    private String stadt;

    @NotBlank(message= "Hausnummer ist erforderlich")
    private String hausnummer;

    private int postleizahl;


}
