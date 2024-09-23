package api.ecommerce.br.apiecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 
import api.ecommerce.br.apiecommerce.model.Product;



@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {

    Product findByQuantityProducts(Long quantityProduct);
}
