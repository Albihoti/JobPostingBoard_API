package com.example.jobpostingboard_api.service;


import com.example.jobpostingboard_api.dto.JobPostDto;
import com.example.jobpostingboard_api.entity.JobPost;
import com.example.jobpostingboard_api.repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {

    private final JobPostRepository jobPostRepository;
    private final CompanyService companyService;
    private final CategoryService categoryService;


    public JobPostDto createJobPost(JobPostDto jobPostDto){
        JobPost jobPost = new JobPost();
            var company =  companyService.getCompanyByUserName(jobPostDto.getCompany());
            var category = categoryService.getCategoryByName(jobPostDto.getCategory());
        jobPost.setDescription(jobPostDto.getDescription());
        jobPost.setLocation(jobPostDto.getLocation());
        jobPost.setTitle(jobPostDto.getTitle());
        jobPost.setSalary(jobPostDto.getSalary());
        jobPost.setStatus(jobPostDto.getStatus());
        jobPost.setEndDate(jobPostDto.getEndDate());
        jobPost.setCompany(company);
        jobPost.setCompanyName(company.getName());
        jobPost.setCategory(category);
        jobPostRepository.save(jobPost);
        return jobPostDto;


    }


    public List<JobPost>    getAll() {
       return jobPostRepository.findAll();
    }
}
