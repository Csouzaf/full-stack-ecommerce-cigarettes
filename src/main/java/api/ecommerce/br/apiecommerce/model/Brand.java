package api.ecommerce.br.apiecommerce.model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "brand")
@Getter
@Setter
@ToString
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="name")
    private String name;

    @Column(name="category")
    private String category;

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    private List<Model> models;

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    private List<Products> products;


    
}
