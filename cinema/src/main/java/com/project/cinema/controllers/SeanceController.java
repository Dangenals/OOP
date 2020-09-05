package com.project.cinema.controllers;


import com.project.cinema.model.Customer;
import com.project.cinema.model.Seance;
import com.project.cinema.services.SeanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeanceController {
    private SeanceService seanceService;

    private SeanceController (SeanceService seanceService) {
        this.seanceService = seanceService;
    }


    @GetMapping("/seances")
    public List<Seance> getAllSeances() {
        return seanceService.getAllSeance();
    }


    @GetMapping( "/seances/{id}")
    public Seance getCustomerById(@PathVariable int id) {
        return seanceService.getSeanceById(id);
    }

    @DeleteMapping("/seances/{id}")
    public String deleteSeanceById(@PathVariable int id) {
        seanceService.deleteSeanceById(id);
        return "Seance was deleted";
    }


    @PostMapping("/seances")
    public String createSeance(@RequestBody Seance seance){
        seanceService.createSeance(seance);
        return "Seance was added";
    }
}
