package api.ecommerce.br.apiecommerce.config.auth;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterRequest {

    private String fullName;
    private String email;
    private String phoneNumber;
    private String cpf;
    private String password;
    private String address;
    private String role;
    
}
