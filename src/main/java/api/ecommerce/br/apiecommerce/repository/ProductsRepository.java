package api.ecommerce.br.apiecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.ecommerce.br.apiecommerce.model.Products;


public interface ProductsRepository extends JpaRepository<Products, Long> {

}
