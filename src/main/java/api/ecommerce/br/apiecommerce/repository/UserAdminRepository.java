package api.ecommerce.br.apiecommerce.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.ecommerce.br.apiecommerce.model.UserAdm;
import api.ecommerce.br.apiecommerce.model.UserModel;
import java.util.List;


@Repository
public interface UserAdminRepository extends JpaRepository<UserAdm, Long>{
  
    Optional<UserModel> findByEmail(String email);

}
