package com.gym.gym_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
@Table(name = "workout_plans")
public class WorkoutPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Plan name is required")
    private String planName;

    @Min(value = 1, message = "Duration must be at least 1 month")
    private int durationMonths;

    @Min(value = 0, message = "Price cannot be negative")
    private double price;

    private String description;
}

