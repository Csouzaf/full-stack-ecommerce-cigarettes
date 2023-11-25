package api.ecommerce.br.apiecommerce.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import api.ecommerce.br.apiecommerce.model.ShoppingCartModel;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCartModel, Long>{
    
}
