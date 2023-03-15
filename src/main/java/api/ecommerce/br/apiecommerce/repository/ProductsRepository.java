package api.ecommerce.br.apiecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import api.ecommerce.br.apiecommerce.model.ProductsModel;


public interface ProductsRepository extends CrudRepository<ProductsModel, Long> {


}
