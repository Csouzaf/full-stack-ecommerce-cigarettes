package api.ecommerce.br.apiecommerce.config.jwt;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import api.ecommerce.br.apiecommerce.model.UserAdm;
import api.ecommerce.br.apiecommerce.model.UserModel;
import api.ecommerce.br.apiecommerce.repository.UserAdminRepository;
import api.ecommerce.br.apiecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;


@Configuration
@RequiredArgsConstructor

public class ApplicationConfig {

    private final UserRepository repository;
    
    private final UserAdminRepository userAdminRepository;

    @Bean
    public UserDetailsService userDetailsService() {
     
      return username -> {
            UserModel userModel = repository.findByEmail(username); 
            if (userModel != null) {
                return (UserDetails) userModel; 
            }

            UserAdm userAdm = userAdminRepository.findByEmail(username);
            if (userAdm != null) {
                return (UserDetails) userAdm; 
            }

            throw new UsernameNotFoundException("Usuário não encontrado");
        };
           
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
