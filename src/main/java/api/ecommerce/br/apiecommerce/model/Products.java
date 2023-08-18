package api.ecommerce.br.apiecommerce.model;

import org.hibernate.annotations.ManyToAny;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")

public class Products {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "nameProducts", nullable = false)
    private String name;
    

    @Column(name = "quantity_Stock", nullable = true)
    private int quantityStock;

    
    @Column(name = "quantityProducts", nullable = true)
    private int quantity;


    @Column(name = "unitary_Value", nullable = false)
    private Double unitaryValue;

    @OneToOne
    @JoinColumn(name = "usermodel_ld")
    private UserModel userModelProducts;

    // @ManyToOne
    // @JoinColumn(name = "productsUserId")
    // private ProductsUser productsUser;


}
