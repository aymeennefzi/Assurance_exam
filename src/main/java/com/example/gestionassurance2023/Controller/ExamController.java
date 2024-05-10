package com.example.gestionassurance2023.Controller;

import com.example.gestionassurance2023.Entity.Evenement;
import com.example.gestionassurance2023.Entity.Logistique;
import com.example.gestionassurance2023.Entity.Participant;
import com.example.gestionassurance2023.Service.IExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExamController {
    private final IExamService iExamService ;

    public Participant ajouterParticipant (Participant p){
        return iExamService.ajouterParticipant(p);
    }

    @PostMapping("/add")
    public Evenement ajoutAffectEvenParticip(@RequestBody Evenement e) {
    return iExamService.ajoutAffectEvenParticip(e);
    }

    @GetMapping("get")
    public List<Evenement> gettAll() {
        return iExamService.gettAll();
    }

    @PostMapping("/add2/{nom}/{prenom}")
    public Evenement ajoutAffectEvenParticip2(@RequestBody  Evenement e, @PathVariable ("nom") String nom,@PathVariable ("prenom") String prenom) {
        return iExamService.ajoutAffectEvenParticip2(e , nom , prenom);
    }

    @PostMapping("/add/{des}")
    public Logistique ajoutAffectLogEvnm(@RequestBody Logistique l, @PathVariable ("des") String descriptionEvnmt) {
        return iExamService.ajoutAffectLogEvnm(l ,descriptionEvnmt);
    }

    @GetMapping("/get/{datedeb}/{datefin}")
    public List<Logistique> getLogistiquesDates(@PathVariable ("datedeb") LocalDate dateDeb,@PathVariable ("datefin") LocalDate dateFin) {
        return iExamService.getLogistiquesDates(dateDeb,dateFin);
    }

//    @GetMapping("/get/{nom}")
//    public List<Logistique> getLogistiquesbynom(@PathVariable("nom") String nom) {
//        return iExamService.getLogistiquesbynom(nom);
//    }
    }
