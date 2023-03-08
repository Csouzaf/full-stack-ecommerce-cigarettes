package api.ecommerce.br.apiecommerce.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import api.ecommerce.br.apiecommerce.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{
    
    Optional<UserModel> findByEmail(String email);
}
