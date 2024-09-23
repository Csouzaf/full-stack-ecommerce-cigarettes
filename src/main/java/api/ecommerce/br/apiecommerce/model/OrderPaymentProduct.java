package api.ecommerce.br.apiecommerce.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

import api.ecommerce.br.apiecommerce.enums.PaymentMethod;

@Entity
@Table(name = "order_payment_product")
@Getter
@Setter
public class OrderPaymentProduct{
    
    @Id
    private String id;
       
    @Column(name = "current_date")
    private LocalDateTime currentDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel userModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="payment_product_id", nullable = false)
    private PaymentProduct paymentProduct;

    public OrderPaymentProduct() {
        this.id = UUID.randomUUID().toString();
    }
    

}
