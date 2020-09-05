package com.project.cinema.services;

import com.project.cinema.model.Seance;
import com.project.cinema.repository.SeanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SeanceService {
    private SeanceRepository seanceRepository;

    public SeanceService(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    public List<Seance> getAllSeance() {
        return seanceRepository.getAllSeances();
    }

    public Seance getSeanceById(int id) {
        return seanceRepository.getSeanceById(id);
    }

    public void deleteSeanceById(int id) {
        seanceRepository.deleteSeanceById(id);
    }

    public void createSeance(Seance seance) {
        seanceRepository.insertSeance(seance);
    }
}