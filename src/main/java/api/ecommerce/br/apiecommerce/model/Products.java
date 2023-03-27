package api.ecommerce.br.apiecommerce.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "products")

public class Products {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private Double dunhillRed;
    
    @Column(nullable = true)
    private Double dunhillBlue;
    
    @Column(nullable = true)
    private Double dunhillOnRed;
    
    @Column(nullable = true)
    private Double dunhilOnBlue;
    
    @Column(nullable = false)
    private Double sumItems;


}
