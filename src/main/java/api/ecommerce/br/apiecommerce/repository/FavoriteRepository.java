package api.ecommerce.br.apiecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.ecommerce.br.apiecommerce.model.Favorite;


import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long>{
    
	List<Favorite> findByUserModel(int id);

	List<Favorite> findByProductIdAndUserModelId(Long productId, Long userId);

	Optional<Favorite> findById(int id);
}
