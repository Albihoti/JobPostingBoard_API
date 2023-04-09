package com.example.jobpostingboard_api.service;


import com.example.jobpostingboard_api.dto.AddressRequestDto;
import com.example.jobpostingboard_api.entity.Address;
import com.example.jobpostingboard_api.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {
    
    private final AddressRepository addressRepository;



    public Address addNewAddress(AddressRequestDto addressRequestDto) {
        var address = new Address();
        address.setCity(addressRequestDto.getCity());
        address.setState(addressRequestDto.getState());
        address.setStreet(addressRequestDto.getStreet());
        address.setZipCode(addressRequestDto.getZipCode());

        addressRepository.save(address);

        return address;


    }

    public Address findAddressById(Integer id){
       return addressRepository.findById(id).orElse(null);
    }
}
