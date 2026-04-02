package com.gym.gym_management.service;

import com.gym.gym_management.entity.Trainer;
import com.gym.gym_management.repository.TrainerRepository;
import com.gym.gym_management.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }
    public Trainer getTrainerById(Long id) {
        return trainerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
                "Trainer not found with id: " + id));
    }
    
    public Trainer saveTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public Trainer updateTrainer(Long id, Trainer trainer) {
        trainer.setId(id);
        return trainerRepository.save(trainer);
    }

    public void deleteTrainer(Long id) {
        trainerRepository.deleteById(id);
    }
}