package com.example.jobpostingboard_api.auth;


import com.example.jobpostingboardapi.configuration.JwtService;
import com.example.jobpostingboardapi.entity.User;
import com.example.jobpostingboardapi.enums.UserRoles;
import com.example.jobpostingboardapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        var user  = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .emailAddress(request.getEmailAddress())
                .password(passwordEncoder.encode(request.getPassword()))
                .contactNumber(request.getContactNumber())
                .userRole(UserRoles.APPLICANT)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();

    }

    public AuthenticationResponse login(LoginRequest request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmailAddress(), request.getPassword()));
        var user = userRepository.findByEmailAddress(request.getEmailAddress()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
