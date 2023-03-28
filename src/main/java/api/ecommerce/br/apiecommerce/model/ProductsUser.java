package api.ecommerce.br.apiecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productUser")

public class ProductsUser {
    
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private UserModel idUser;

    @ManyToOne
    @JoinColumn(referencedColumnName = "code")
    private Products idProductsUser;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "addres")
    private UserModel addressUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "fullName")
    private UserModel fullNameUser;

    @ManyToOne
    @JoinColumn(referencedColumnName = "quantity")
    @Column(nullable = false)
    private Products quantityPaid;
     
    @Column(nullable = false)
    private Double amountPaid;

    @Column(name = "paymentMethod")
    private String paymentMethod;

}    
