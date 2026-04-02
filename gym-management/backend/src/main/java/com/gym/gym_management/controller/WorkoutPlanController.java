package com.gym.gym_management.controller;

import com.gym.gym_management.entity.WorkoutPlan;
import com.gym.gym_management.service.WorkoutPlanService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/plans")
public class WorkoutPlanController {

    @Autowired
    private WorkoutPlanService workoutPlanService;

    @GetMapping
    public List<WorkoutPlan> getAllPlans() {
        return workoutPlanService.getAllPlans();
    }

    @GetMapping("/{id}")
    public WorkoutPlan getPlanById(@PathVariable Long id) {
        return workoutPlanService.getPlanById(id);
    }

    @PostMapping
    public WorkoutPlan createPlan(@Valid @RequestBody WorkoutPlan plan) {
    return workoutPlanService.savePlan(plan);
    }

    @PutMapping("/{id}")
    public WorkoutPlan updatePlan(@PathVariable Long id, @RequestBody WorkoutPlan plan) {
        return workoutPlanService.updatePlan(id, plan);
    }

    @DeleteMapping("/{id}")
    public String deletePlan(@PathVariable Long id) {
        workoutPlanService.deletePlan(id);
        return "Plan deleted successfully!";
    }
}