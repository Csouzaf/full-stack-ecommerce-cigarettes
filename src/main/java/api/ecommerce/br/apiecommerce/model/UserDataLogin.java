package api.ecommerce.br.apiecommerce.model;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userData")
public class UserDataLogin {
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    private UserModel id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addressUser", referencedColumnName = "addres")
    private UserModel addressUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fullNameUser", referencedColumnName = "fullName")
    private UserModel fullNameUser;

    @Column(name = "paymentMethod")
    private String paymentMethod;
}
