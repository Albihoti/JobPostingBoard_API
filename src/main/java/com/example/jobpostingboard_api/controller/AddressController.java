package com.example.jobpostingboard_api.controller;


import com.example.jobpostingboard_api.dto.AddressRequestDto;
import com.example.jobpostingboard_api.entity.Address;
import com.example.jobpostingboard_api.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {


    private final AddressService addressService;
    @PostMapping("")
    public ResponseEntity<Address> addNewAddress(@RequestBody AddressRequestDto addressRequestDto){
        return ResponseEntity.ok(addressService.addNewAddress(addressRequestDto));
    }
}
