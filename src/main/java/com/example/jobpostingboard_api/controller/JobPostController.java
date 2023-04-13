package com.example.jobpostingboard_api.controller;



import com.example.jobpostingboard_api.dto.JobPostDto;
import com.example.jobpostingboard_api.entity.JobPost;
import com.example.jobpostingboard_api.service.JobPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/jobPost")
@RequiredArgsConstructor
public class JobPostController {

    private final JobPostService jobPostService;



    @PostMapping("/register")
    public ResponseEntity<JobPostDto> createJobPost(@RequestBody JobPostDto jobPostDto){
        System.out.println("Hello from jobPost");

        return ResponseEntity.ok(jobPostService.createJobPost(jobPostDto));

    }

    @GetMapping("/all")
    public ResponseEntity<List<JobPost>> getAllJobPost(){

        return ResponseEntity.ok(jobPostService.getAll());

    }



}
