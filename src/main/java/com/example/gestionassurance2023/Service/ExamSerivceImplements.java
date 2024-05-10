package com.example.gestionassurance2023.Service;

import com.example.gestionassurance2023.Entity.Evenement;
import com.example.gestionassurance2023.Entity.Logistique;
import com.example.gestionassurance2023.Entity.Participant;
import com.example.gestionassurance2023.Respository.IEvenementRepository;
import com.example.gestionassurance2023.Respository.ILogistiqueRepository;
import com.example.gestionassurance2023.Respository.IParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class ExamSerivceImplements implements IExamService {
    private final IEvenementRepository iEvenementRepository;
    private final ILogistiqueRepository iLogistiqueRepository;
    private final IParticipantRepository iParticipantRepository;

    @Override
    public Participant ajouterParticipant(Participant p) {
        return iParticipantRepository.save(p);
    }

//    @Override
//    @Transactional
//    public Evenement ajoutAffectEvenParticip(Evenement e) {
//        iEvenementRepository.save(e);
//        for (Participant p : e.getParticipant()) {
//            String nom = p.getNom();
//            String prenom = p.getPrenom();
//            Participant participant = iParticipantRepository.findByNomAndPrenom(nom, prenom);
//            Set<Participant> p1 = new HashSet<>();
//            p1.add(participant);
//            e.setParticipant(p1);
//        }
//        return e;
//    }


    @Override
    public List<Evenement> gettAll() {
        return iEvenementRepository.findAll();

    }

    @Override
    @Transactional
    public Evenement ajoutAffectEvenParticip2(Evenement e, String nom, String prenom) {

            Participant p1 = iParticipantRepository.findByNomAndPrenom(nom , prenom);
            if (e.getParticipant()==null) {
                Set<Participant> participants = new HashSet<>();
                participants.add(p1);
                e.setParticipant(participants);
            }else {
                e.getParticipant().add(p1);
            }
        return iEvenementRepository.save(e);
    }

    @Override
    @Transactional
    public Logistique ajoutAffectLogEvnm(Logistique l, String descriptionEvnmt) {
        Evenement evenement = iEvenementRepository.findByDescription(descriptionEvnmt);
        if (evenement.getLogistiques()==null){
        Set<Logistique> logistiques =new HashSet<>();
        logistiques.add(l);
            evenement.setLogistiques(logistiques);
        }else {
            evenement.getLogistiques().add(l);
        }
        return iLogistiqueRepository.save(l);
    }

    @Override
    public List<Logistique> getLogistiquesDates(LocalDate dateDeb, LocalDate dateFin) {
        return iLogistiqueRepository.findyhhhhbyDate(dateDeb , dateFin);
    }

//    @Override
//    public List<Logistique> getLogistiquesbynom(String nom) {
//        return iLogistiqueRepository.findyhhhhbyNom(nom);
//    }


    @Override
    public Evenement ajoutAffectEvenParticip(Evenement e) {

        for (Participant p : e.getParticipant()){
            String nom = p.getNom();
            String prenom =p.getPrenom();
            Participant participant = iParticipantRepository.findByNomAndPrenom(nom ,prenom);
            Set<Participant> participants =new HashSet<>();
            participants.add(participant);
            e.setParticipant(participants);
        }
        return iEvenementRepository.save(e);
    }
}
