// package api.ecommerce.br.apiecommerce.model;


// import java.util.List;

// import org.hibernate.annotations.ManyToAny;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// @Entity
// @Table(name = "product_users")

// public class ProductsUser {
    
//     @Id
//     private Long id;

//     // @OneToMany(mappedBy = "")
//     // @JoinColumn(name = "id_users",referencedColumnName = "id")
//     // private UserModel idUser;

//     // @OneToMany(mappedBy = "")
//     // @JoinColumn(name = "id_Products_users",referencedColumnName = "code")
//     // private Products idProductsUser;
    
//     // @ManyToOne
//     // @JoinColumn(name = "id")
//     // private UserModel user;

//     // @OneToMany(mappedBy = "products", fetch = FetchType.EAGER)
//     // private List<Products> products;
     
//     @Column(name = "amount_paid", nullable = false)
//     private Double amountPaid;

//     @Column(name = "payment_method")
//     private String paymentMethod;

// }    
 