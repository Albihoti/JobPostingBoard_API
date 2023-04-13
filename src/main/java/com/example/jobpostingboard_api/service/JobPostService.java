package com.example.jobpostingboard_api.service;


import com.example.jobpostingboard_api.dto.JobPostDto;
import com.example.jobpostingboard_api.entity.JobPost;
import com.example.jobpostingboard_api.enums.JobStatus;
import com.example.jobpostingboard_api.repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
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


    public JobPost getJobpost(int id){
        return jobPostRepository.findById(id).orElse(null);}


    @Scheduled(cron = "0 0 */48 * * ?")
    public void deleteJobPost(){
       var jobPost = jobPostRepository.findJobPostsByStatus(JobStatus.EXPIRED).orElse(null);
       jobPostRepository.delete(jobPost);

    }
}
