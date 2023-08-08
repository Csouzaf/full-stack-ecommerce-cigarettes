package api.ecommerce.br.apiecommerce.model;


import java.util.List;

import org.hibernate.annotations.ManyToAny;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productusers")

public class ProductsUser {
    
    @Id
    private Long id;

    @Column(name = "amount_paid", nullable = false)
    private Double amountPaid;

    @Column(name = "payment_method")
    private String paymentMethod;

    @OneToOne
    @JoinColumn(name = "userEmail_ld")
    private UserEmail userEmail;

    @OneToMany(mappedBy = "productsUser")
    private List<Products> products;



}    
 