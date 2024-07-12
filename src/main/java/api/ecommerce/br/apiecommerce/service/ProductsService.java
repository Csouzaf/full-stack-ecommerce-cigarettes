package api.ecommerce.br.apiecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import api.ecommerce.br.apiecommerce.config.auth.AuthenticationRequest;
import api.ecommerce.br.apiecommerce.exception.ResourceNotFoundException;
import api.ecommerce.br.apiecommerce.model.Products;
import api.ecommerce.br.apiecommerce.repository.ProductsRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public List<Products> listProducts() {
        return this.productsRepository.findAll();
    }

    public boolean verifyUserIsAuthenticated() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated()) {
            return false;
        }
        return true;
    }

    public boolean verifyIsAdminRole() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        boolean hasAdminRole = auth.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ADMIN"));

        if (!hasAdminRole) {
            return false;
        }
        return true;
    }

    public Products createProducts(Products products) {

        if (verifyUserIsAuthenticated() && verifyIsAdminRole()) {
            Products productsSave = productsRepository.save(products);
            return productsSave;
        }
        return null;

    }

    public Products updateProducts(Long id, Products products) {

        if (verifyUserIsAuthenticated() && verifyIsAdminRole()) {
            Products productsExist = productsRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com ID: " + id));

            productsExist.setQuantityStock(products.getQuantityStock());

            return productsRepository.save(productsExist);
        }
        return null;
    }

    public void removeProducts(Long id) {

        if (verifyUserIsAuthenticated() && verifyIsAdminRole()) {
            Products productsExist = productsRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com ID: " + id));

            productsRepository.delete(productsExist);
        }

    }

}