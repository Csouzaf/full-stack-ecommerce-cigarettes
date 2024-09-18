package api.ecommerce.br.apiecommerce.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

import java.time.LocalDateTime;

import java.util.List;

import org.hibernate.id.uuid.UuidGenerator;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "payment")
@Getter
@Setter
public class PaymentProduct {
    
    @Id
    private String id;
    
    @Column(name = "tax")
    private Double tax;
    
    @NotNull
    @Column(name = "amount_Value")
    private Double amountValue;

    @Column(name = "current_date")
    private LocalDateTime currentDate;

    @NotNull
    @Column(name = "payment_method")
    private String paymentMethod;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel userModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="products_id", nullable = false)
    private Product product;

    public PaymentProduct() {
        this.id = UUID.randomUUID().toString();
    }
    

}
