package com.example.jobpostingboard_api.repository;

import com.example.jobpostingboard_api.entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostRepository extends JpaRepository<JobPost, Integer> {
}
