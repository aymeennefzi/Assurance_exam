package com.example.gestionassurance2023.Respository;

import com.example.gestionassurance2023.Entity.Logistique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ILogistiqueRepository extends JpaRepository<Logistique, Integer> {
@Query("select l from Logistique l join Evenement e on l member of e.logistiques where (e.dateDebut<=:datefin and e.dateFin>=:datedebut)")
    List<Logistique> findyhhhhbyDate(@Param("datedebut") LocalDate datedebut ,@Param("datefin") LocalDate dateFin );

@Query("select l from Logistique l join Evenement e join e.participant p on l member of e.logistiques where p.nom=:nom  ")
    List<Logistique> findyhhhhbyNom (@Param("nom") String nom);
}
