package com.example.jobpostingboard_api.controller;


import com.example.jobpostingboard_api.dto.AddressRequestDto;
import com.example.jobpostingboard_api.entity.Address;
import com.example.jobpostingboard_api.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {


    private final AddressService addressService;
    @PostMapping("")
    public ResponseEntity<Address> addNewAddress(@RequestBody AddressRequestDto addressRequestDto){
        return ResponseEntity.ok(addressService.addNewAddress(addressRequestDto));
    }

    @GetMapping("/all")
    public  ResponseEntity<List<Address>> getAllAddresses(){
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") int id){
        return ResponseEntity.ok(addressService.findAddressById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddressById(@PathVariable("id") int id, @RequestBody AddressRequestDto addressRequestDto){
        return ResponseEntity.ok(addressService.updateAddressById(id, addressRequestDto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddressById(@PathVariable int id){
        return ResponseEntity.ok(addressService.deleteAddressById(id));

    }


}
