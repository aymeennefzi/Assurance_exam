package com.example.gestionassurance2023.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Evenement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;
    String description ;
    @Temporal(TemporalType.DATE)
    LocalDate dateDebut;
    @Temporal(TemporalType.DATE)
    LocalDate dateFin ;
    float cout ;

    @ManyToMany
    Set<Participant> participant ;

    @OneToMany
    Set<Logistique> logistiques ;
}
