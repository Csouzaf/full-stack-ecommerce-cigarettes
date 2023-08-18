package api.ecommerce.br.apiecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.ecommerce.br.apiecommerce.model.ProductsUser;

@Repository
public interface ProductsUserRepository extends JpaRepository<ProductsUser, Long>{
    
}
