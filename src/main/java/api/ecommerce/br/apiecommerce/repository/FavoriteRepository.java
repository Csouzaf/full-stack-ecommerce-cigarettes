package api.ecommerce.br.apiecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import api.ecommerce.br.apiecommerce.model.Brand;
import api.ecommerce.br.apiecommerce.model.Favorite;
import api.ecommerce.br.apiecommerce.model.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long>{
    
	List<Favorite> findByUserModel(int id);

	Optional<Favorite> findById(int id);
}
