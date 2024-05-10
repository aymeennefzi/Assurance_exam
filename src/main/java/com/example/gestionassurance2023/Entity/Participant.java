package com.example.gestionassurance2023.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Participant implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int idPart ;
    String nom ;
    String prenom ;
    @Enumerated (value = EnumType.STRING)
    Tache tache ;

    @ManyToMany (mappedBy = "participant" , fetch = FetchType.EAGER)
    Set<Evenement> evenements ;

}
