package api.ecommerce.br.apiecommerce.config.auth;



import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import api.ecommerce.br.apiecommerce.config.JwtService;
import api.ecommerce.br.apiecommerce.model.UserModel;
import api.ecommerce.br.apiecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AuthenticationService {
     
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        var user = UserModel.builder()

            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .build();
        
        repository.save(user);
        
        var jwtToken = jwtService.generatedToken(user);
        
        return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
       authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()
            )
        
        );

        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        
        var jwtToken = jwtService.generatedToken(user);
        
        return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();

    }


}
    

