package com.pm.backend_buchanalyse.repository;

import com.pm.backend_buchanalyse.models.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Integer> {

}
