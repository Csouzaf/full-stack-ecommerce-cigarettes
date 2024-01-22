package api.ecommerce.br.apiecommerce.model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.fasterxml.jackson.annotation.JsonIgnore;

import api.ecommerce.br.apiecommerce.enums.Cigarrets;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
public class Products {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity_Stock")
    private int quantityStock;

    @NotNull
    @Column(name = "quantity_products")
    private int quantityProducts;

    @NotNull
    @Column(name = "unitary_Value")
    private Double unitaryValue;

    @JsonIgnore
    @OneToMany(mappedBy = "products")
    private List<ShoppingCartModel> shoppingCart;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel userModel;

    @ManyToOne()
    private Brand brand;
    

}
