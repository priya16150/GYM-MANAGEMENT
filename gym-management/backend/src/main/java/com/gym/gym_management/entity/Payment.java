package com.gym.gym_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @NotNull(message = "Member ID is required")
    private Long memberId;

    @Min(value = 0, message = "Amount cannot be negative")
    private double amount;

    private LocalDate paymentDate;

    private String status;
}