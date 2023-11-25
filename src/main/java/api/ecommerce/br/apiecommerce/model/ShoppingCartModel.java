package api.ecommerce.br.apiecommerce.model;


import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "shoppingCart")
@Getter
@Setter
@ToString

public class ShoppingCartModel {
    
    @Id
    private Long id;

    @NotNull
    @Column(name = "amount_paid")
    private Double amountPaid;

    @NotNull
    @Column(name = "payment_method")
    private String paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="products_id", nullable = false)
    private Products products;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel userModel;
}    
 