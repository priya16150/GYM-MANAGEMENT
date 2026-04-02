package com.gym.gym_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gym.gym_management.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}