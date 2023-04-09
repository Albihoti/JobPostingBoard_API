package com.example.jobpostingboard_api.service;


import com.example.jobpostingboard_api.dto.CompanyRequestDto;
import com.example.jobpostingboard_api.entity.Address;
import com.example.jobpostingboard_api.entity.Company;
import com.example.jobpostingboard_api.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final AddressService addressService;


    public Company register(CompanyRequestDto companyRequestDto) {

            Company company = new Company();
            company.setEmail(companyRequestDto.getEmail());
            company.setName(companyRequestDto.getName());
            company.setUserName(companyRequestDto.getUserName());
            company.setIndustry(companyRequestDto.getIndustry());
            company.setWebsite(companyRequestDto.getWebsite());
            company.setContactNumber(companyRequestDto.getContactNumber());
            company.setLogo(companyRequestDto.getLogo());

            Address address = addressService.findAddressById(companyRequestDto.getAddressID());

            company.setAddress(address);

            companyRepository.save(company);


        return company;
    }
}
