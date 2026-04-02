package com.gym.gym_management.service;

import com.gym.gym_management.entity.WorkoutPlan;
import com.gym.gym_management.repository.WorkoutPlanRepository;
import com.gym.gym_management.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkoutPlanService {

    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    public List<WorkoutPlan> getAllPlans() {
        return workoutPlanRepository.findAll();
    }

    public WorkoutPlan getPlanById(Long id) {
        return workoutPlanRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
                "WorkoutPlan not found with id: " + id));
    }

    public WorkoutPlan savePlan(WorkoutPlan plan) {
        return workoutPlanRepository.save(plan);
    }

    public WorkoutPlan updatePlan(Long id, WorkoutPlan plan) {
        plan.setId(id);
        return workoutPlanRepository.save(plan);
    }

    public void deletePlan(Long id) {
        workoutPlanRepository.deleteById(id);
    }
}