package api.ecommerce.br.apiecommerce.model;



import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data

public class UserEmail {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    
    private String fullName;
    
    private String cpf;

    private String address;

    private String phoneNumber;

    @OneToOne
    @JoinColumn(name="userModel_Id")
    private UserModel userModel;

    // @OneToOne(mappedBy = "userEmail")
    // private ProductsUser productsUser;


}
