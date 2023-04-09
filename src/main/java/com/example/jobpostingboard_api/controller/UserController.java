package com.example.jobpostingboard_api.controller;


import com.example.jobpostingboard_api.auth.AuthenticationService;
import com.example.jobpostingboard_api.dto.UserDto;
import com.example.jobpostingboard_api.entity.User;
import com.example.jobpostingboard_api.enums.UserRoles;
import com.example.jobpostingboard_api.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

        private final UserService userService;


    @GetMapping("/me")
    public ResponseEntity<UserDto> getUserByToken(HttpServletRequest request){


        return ResponseEntity.ok(userService.getMe(request));

    }


    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){

        return ResponseEntity.ok(userService.getAllUsers());

    }



    @PutMapping("")
    public ResponseEntity<UserDto> updateProfile(@RequestBody UserDto userDto, HttpServletRequest request){
        return ResponseEntity.ok(userService.updateProfile(userDto, request));
    }
}
