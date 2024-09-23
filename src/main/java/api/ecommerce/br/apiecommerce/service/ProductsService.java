package api.ecommerce.br.apiecommerce.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.ecommerce.br.apiecommerce.config.auth.VerifyAuthentication;
import api.ecommerce.br.apiecommerce.exception.ResourceNotFoundException;
import api.ecommerce.br.apiecommerce.model.Product;
import api.ecommerce.br.apiecommerce.repository.ProductsRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private VerifyAuthentication auth;
    
    public List<Product> listProducts() {
        return this.productsRepository.findAll();
    }

    public Product createProducts(Product products) {

        if (auth.verifyUserIsAuthenticated() && auth.verifyIsAdminRole() || auth.verifyIsOwnerRole()) {
            
            products.setCurrentDate(LocalDateTime.now());
            products.setUserModel(auth.userAuthenticated());

            Product productsSave = productsRepository.save(products);
            return productsSave;
        }
        return null;

    }

    public Product updateProducts(Long id, Product products) {

        if (auth.verifyUserIsAuthenticated() && auth.verifyIsAdminRole()) {
            Product productsExist = productsRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com ID: " + id));

            productsExist.setQuantityStock(products.getQuantityStock());

            return productsRepository.save(productsExist);
        }
        
        return null;
    }

    public void removeProducts(Long id) {
    
        if (auth.verifyUserIsAuthenticated() && auth.verifyIsAdminRole()) {
            Product productsExist = productsRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com ID: " + id));

            productsRepository.delete(productsExist);
        }

    }

}