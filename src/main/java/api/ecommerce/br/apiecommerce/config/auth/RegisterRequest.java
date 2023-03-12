package api.ecommerce.br.apiecommerce.config.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class RegisterRequest {

    private String email;
    private String password;
}
