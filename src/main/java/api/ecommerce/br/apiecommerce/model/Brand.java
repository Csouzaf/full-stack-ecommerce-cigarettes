package api.ecommerce.br.apiecommerce.model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "brand")
@Getter
@Setter
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    private String category;

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Model> models;

    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Products> products;


    
}
