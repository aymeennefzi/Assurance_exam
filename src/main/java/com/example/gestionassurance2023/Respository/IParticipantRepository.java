package com.example.gestionassurance2023.Respository;

import com.example.gestionassurance2023.Entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IParticipantRepository extends JpaRepository<Participant, Integer> {
    Participant findByNomAndPrenom (String nom , String prenom);
}
