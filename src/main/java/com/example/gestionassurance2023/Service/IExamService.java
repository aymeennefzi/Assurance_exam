package com.example.gestionassurance2023.Service;

import com.example.gestionassurance2023.Entity.Evenement;
import com.example.gestionassurance2023.Entity.Logistique;
import com.example.gestionassurance2023.Entity.Participant;

import java.time.LocalDate;
import java.util.List;

public interface IExamService {
    public Participant ajouterParticipant (Participant p);
    public Evenement ajoutAffectEvenParticip (Evenement e) ;
    List<Evenement> gettAll();
    public Evenement ajoutAffectEvenParticip2(Evenement e , String nom , String prenom);

    public Logistique ajoutAffectLogEvnm (Logistique l, String descriptionEvnmt) ;
    public List <Logistique> getLogistiquesDates (LocalDate dateDeb, LocalDate dateFin);
//    public List <Logistique> getLogistiquesbynom (String  nom);


}
