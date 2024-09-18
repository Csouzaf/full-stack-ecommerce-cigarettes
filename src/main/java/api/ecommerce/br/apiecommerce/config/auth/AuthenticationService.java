package api.ecommerce.br.apiecommerce.config.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import api.ecommerce.br.apiecommerce.config.jwt.JwtService;
import api.ecommerce.br.apiecommerce.model.Role;
import api.ecommerce.br.apiecommerce.model.UserAdm;
import api.ecommerce.br.apiecommerce.model.UserEmail;
import api.ecommerce.br.apiecommerce.model.UserModel;
import api.ecommerce.br.apiecommerce.repository.UserAdminRepository;
import api.ecommerce.br.apiecommerce.repository.UserEmailRepository;
import api.ecommerce.br.apiecommerce.repository.UserRepository;
import ch.qos.logback.core.joran.conditional.ElseAction;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AuthenticationService {
     
    private final UserRepository repository;
    private final UserAdminRepository userAdminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserEmailRepository userEmailRepository;
   

    public AuthenticationResponse register(RegisterRequest request) {

        if (request.getRole().equals("ADMIN")) {
            
            var userAdm = UserAdm.builder()

            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .cpf(request.getCpf())
            .fullName(request.getFullName())
            .phoneNumber(request.getPhoneNumber())
            .address(request.getAddress())
            .role(Role.ADMIN)
            .build();
        
            userAdminRepository.save(userAdm);

            var jwtTokenAdm = jwtService.generatedToken(userAdm);
            
            return AuthenticationResponse.builder()
                .token(jwtTokenAdm)
                .build();
        }

        else {

            var user = UserModel.builder()
    
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .cpf(request.getCpf())
                .fullName(request.getFullName())
                .phoneNumber(request.getPhoneNumber())
                .address(request.getAddress())
                .role(Role.USER)
                .build();
            
            repository.save(user);
    
    
            UserEmail userEmail = new UserEmail();
    
            userEmail.setEmail(request.getEmail());
            userEmail.setCpf(request.getCpf());
            userEmail.setFullName(request.getFullName());
            userEmail.setAddress(request.getAddress());
            userEmail.setPhoneNumber(request.getPhoneNumber());
    
            userEmail.setUserModel(user);
            
            userEmailRepository.save(userEmail);

            var jwtToken = jwtService.generatedToken(user);
            
            return AuthenticationResponse.builder()
                .token(jwtToken)            
                .build();
        }
        
    
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        
        );

        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        var userAdm = userAdminRepository.findByEmail(request.getEmail()).orElseThrow();

        var jwtToken = jwtService.generatedToken(user);
        var jwtTokenAdm = jwtService.generatedToken(userAdm);

        return AuthenticationResponse.builder()
            .token(jwtToken)
            .token(jwtTokenAdm)
            .build();

    }


}
    

