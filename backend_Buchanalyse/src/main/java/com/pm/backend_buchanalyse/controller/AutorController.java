package com.pm.backend_buchanalyse.controller;

import com.pm.backend_buchanalyse.models.Autor;
import com.pm.backend_buchanalyse.service.AutorServise;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/autors")
public class AutorController {
    private final AutorServise autorServise;

    public AutorController(AutorServise autorServise) {
        this.autorServise = autorServise;
    }
    @GetMapping
    public ResponseEntity <List<Autor>> getAutors(){
        return ResponseEntity.ok(this.autorServise.getAutors());
    }
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Autor> addAutor( Autor autor){
        return  ResponseEntity.ok(autorServise.addAutor(autor));
    }
    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Autor> updateAutor( Autor autor){
        return  ResponseEntity.ok(autorServise.updateAutor(autor));
    }
}

