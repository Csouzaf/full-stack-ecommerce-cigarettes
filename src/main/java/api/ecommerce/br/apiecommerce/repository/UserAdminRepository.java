package api.ecommerce.br.apiecommerce.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.ecommerce.br.apiecommerce.model.UserAdm;


@Repository
public interface UserAdminRepository extends JpaRepository<UserAdm, Long>{
  
    UserAdm findByEmail(String email);

}
