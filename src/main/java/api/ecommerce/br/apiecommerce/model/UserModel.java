package api.ecommerce.br.apiecommerce.model;


import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Pattern.Flag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "usersEcommerce")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserModel implements UserDetails{
   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "full_Name")
    private String fullName;

    @Column(unique = true)
    @NotEmpty(message = "Email obrigatório")
    @Email(message = "O email informado é inválido", flags = Flag.CASE_INSENSITIVE)
    @Pattern(regexp=".+@.+\\..+", message = "Insira um email válido com @ e um domínio")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "CPF", length = 11)
    private String cpf;

    @Column(name = "address")
    private String address;

    private String password;
    
    // @Enumerated(EnumType.STRING)
    // private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // return List.of(new SimpleGrantedAuthority(role.name()))
        throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
        // return List.of(new SimpleGrantedAuthority(role.email));
    }

    @Override
    public String getUsername() {
        
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

   
   

  
}
