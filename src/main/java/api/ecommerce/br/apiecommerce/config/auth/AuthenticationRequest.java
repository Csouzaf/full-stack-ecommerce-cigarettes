package api.ecommerce.br.apiecommerce.config.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AuthenticationRequest {

    private String email;
    String password;
}
