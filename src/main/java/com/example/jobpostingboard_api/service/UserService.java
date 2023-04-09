package com.example.jobpostingboard_api.service;


import com.example.jobpostingboard_api.configuration.JwtService;
import com.example.jobpostingboard_api.dto.UserDto;
import com.example.jobpostingboard_api.entity.User;
import com.example.jobpostingboard_api.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final  JwtService jwtService;

    public UserDto getMe(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        String token = authorizationHeader.substring("Bearer ".length());
        var username = jwtService.extractUsername(token);
        var user = userRepository.findByEmailAddress(username).orElse(null);

        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setAddress(user.getAddress());
        userDto.setApplications(user.getApplications());
        userDto.setEmailAddress(user.getEmailAddress());
        userDto.setContactNumber(user.getContactNumber());

        return userDto;

    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public UserDto updateProfile(UserDto userDto, HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        String token = authorizationHeader.substring("Bearer ".length());
        var emailAddress = jwtService.extractUsername(token);
        var user = userRepository.findByEmailAddress(emailAddress).orElse(null);



        if(userDto.getFirstName()!=null){
            user.setFirstName(userDto.getFirstName());
        }
        if(userDto.getLastName()!=null){
            user.setLastName(userDto.getLastName());
        }
        if(userDto.getEmailAddress()!=null){
            user.setEmailAddress(userDto.getEmailAddress());
        }
        if(userDto.getContactNumber()!=null){
            user.setContactNumber(userDto.getContactNumber());

        }

        userRepository.save(user);
        return  userDto;

    }
}
