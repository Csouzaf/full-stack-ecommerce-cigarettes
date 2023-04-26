package api.ecommerce.br.apiecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.ecommerce.br.apiecommerce.model.UserModel;

@Repository
public interface UserUpdateDeleteRepository extends JpaRepository<UserModel, String > {
     
    UserModel findByEmail(String email);
}
