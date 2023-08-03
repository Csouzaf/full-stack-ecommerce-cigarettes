package api.ecommerce.br.apiecommerce.config.auth;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.ecommerce.br.apiecommerce.model.UserEmail;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class AuthenticationController {
   
    private final AuthenticationService service;
    @Bean
    public UserEmail myTeste(){
        UserEmail user = new UserEmail();
        // user.setEmail();
        return user;
    }
    // private final UserEmail userEmail;

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> register(@Valid @RequestBody RegisterRequest request) {
        // UserEmail user = new UserEmail();
    
        //     user.setEmail(request.getEmail());

        return ResponseEntity.ok(service.register(request));
        
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@Valid @RequestBody AuthenticationRequest request) {

        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/home")
    public ResponseEntity<String> homePage(){
        return ResponseEntity.ok("Hello");
    }

   


  
}
