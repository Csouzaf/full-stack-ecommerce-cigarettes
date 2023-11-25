package api.ecommerce.br.apiecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.ecommerce.br.apiecommerce.model.UserEmail;

@Repository
public interface UserEmailRepository extends JpaRepository<UserEmail, Long>{

    UserEmail findByEmail(String email);
   
}
