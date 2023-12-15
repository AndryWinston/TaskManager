package com.alexeykalitin.taskmanager.services.JWTServices;

import com.alexeykalitin.taskmanager.auth.AuthenticationRequest;
import com.alexeykalitin.taskmanager.auth.AuthenticationResponse;
import com.alexeykalitin.taskmanager.auth.RegisterRequest;
import com.alexeykalitin.taskmanager.domain.entity.Executor;
import com.alexeykalitin.taskmanager.domain.entity.Role;
import com.alexeykalitin.taskmanager.domain.repositorys.ExecutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final ExecutorRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var executor = Executor.builder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(executor);
        var jwtToken = jwtService.generateToken(executor);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));
        var executor = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(executor);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
