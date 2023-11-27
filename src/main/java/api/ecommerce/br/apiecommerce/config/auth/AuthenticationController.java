package api.ecommerce.br.apiecommerce.config.auth;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
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
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@Valid @RequestBody AuthenticationRequest request) {

        try {
             return ResponseEntity.ok(service.authenticate(request));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
       
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> register(@Valid @RequestBody RegisterRequest request) {

        return ResponseEntity.ok(service.register(request));
        
    }

    @GetMapping("/home")
    public ResponseEntity<String> homePage(){
        return ResponseEntity.ok("Hello");
    }

   


  
}
