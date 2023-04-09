package com.example.jobpostingboard_api.controller;


import com.example.jobpostingboard_api.auth.AuthenticationService;
import com.example.jobpostingboard_api.dto.UserDto;
import com.example.jobpostingboard_api.entity.User;
import com.example.jobpostingboard_api.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

        private final UserService userService;


    @GetMapping("/me")
    public ResponseEntity<UserDto> getUserByToken(HttpServletRequest request){
        String authorizationHeader = request.getHeader("Authorization");
        String token = authorizationHeader.substring("Bearer ".length());

        return ResponseEntity.ok(userService.getMe(token));

    }
}
