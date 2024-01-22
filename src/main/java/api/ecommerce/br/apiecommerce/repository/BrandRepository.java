package api.ecommerce.br.apiecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.ecommerce.br.apiecommerce.model.Brand;
import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{
    
    List<Brand> findByCategory(String category);
}
