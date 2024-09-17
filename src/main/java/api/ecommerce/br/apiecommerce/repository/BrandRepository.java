package api.ecommerce.br.apiecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import api.ecommerce.br.apiecommerce.model.Brand;
import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{
    
    List<Brand> findByCategory(String category);

    Optional <Brand> findById (Long id);

    @Query(value = "SELECT m.name FROM Brand m WHERE m.category = :category")
    List<String> findByName(@Param("category") String category); 
}
