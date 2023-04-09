package com.example.jobpostingboard_api.controller;


import com.example.jobpostingboard_api.dto.CompanyRequestDto;
import com.example.jobpostingboard_api.dto.CompanyResponseDto;
import com.example.jobpostingboard_api.entity.Company;
import com.example.jobpostingboard_api.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;


    @PostMapping("/register")
    public ResponseEntity<Company> registerCompany(@RequestBody CompanyRequestDto companyRequestDto){
        return ResponseEntity.ok(companyService.register(companyRequestDto));
    }
}
