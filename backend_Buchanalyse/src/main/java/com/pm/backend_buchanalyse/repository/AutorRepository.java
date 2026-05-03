package com.pm.backend_buchanalyse.repository;

import com.pm.backend_buchanalyse.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor,Integer> {

}
