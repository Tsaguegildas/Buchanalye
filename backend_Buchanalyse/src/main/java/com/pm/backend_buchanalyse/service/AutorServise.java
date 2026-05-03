package com.pm.backend_buchanalyse.service;
import com.pm.backend_buchanalyse.models.Autor;
import com.pm.backend_buchanalyse.repository.AutorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class AutorServise {

    public AutorRepository autorRepository;
    public List<Autor> getAutors() {
        return autorRepository.findAll()
                .stream().toList();

    }
    public Autor addAutor(Autor autor) {
        return this.autorRepository.save(autor);
    }

    public Autor updateAutor(Autor autor) {
        return this.autorRepository.save(autor);
    }
}
