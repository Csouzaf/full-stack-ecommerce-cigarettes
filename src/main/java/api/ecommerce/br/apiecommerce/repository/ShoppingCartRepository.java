package api.ecommerce.br.apiecommerce.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import api.ecommerce.br.apiecommerce.model.ShoppingCartModel;
import api.ecommerce.br.apiecommerce.model.UserModel;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCartModel, Long>{
    
    UserModel findByUserModelId(Long id);
}
