package api.ecommerce.br.apiecommerce.config.auth;

import api.ecommerce.br.apiecommerce.model.Products;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterRequest {

    private String firstName;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String cpf;
    private String password;
    private String address;
    
}
