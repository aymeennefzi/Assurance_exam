package com.example.gestionassurance2023.Respository;

import com.example.gestionassurance2023.Entity.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEvenementRepository extends JpaRepository<Evenement, Integer> {
    Evenement findByDescription (String description);
}
