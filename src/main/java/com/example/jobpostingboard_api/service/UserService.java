package com.example.jobpostingboard_api.service;


import com.example.jobpostingboard_api.configuration.JwtService;
import com.example.jobpostingboard_api.dto.UserDto;
import com.example.jobpostingboard_api.entity.User;
import com.example.jobpostingboard_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final  JwtService jwtService;

    public UserDto getMe(String token) {
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
}
