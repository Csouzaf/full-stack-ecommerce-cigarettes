package api.ecommerce.br.apiecommerce.service;

import java.util.List;
import java.util.Optional;

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

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductsService {
    
    private ProductsRepository productsRepository;

    
    @Autowired
    private UserRepository userRepository;


    public Iterable<Products> listProducts(){
        return this.productsRepository.findAll();
    }

    public Authentication authenticate(AuthenticationRequest request) {
       
        Authentication authentication = new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        );
        
        // Chame o AuthenticationManager para autenticar
        return authenticationManager.authenticate(authentication);
    }
    
   

    public Products createProducts(Products products){
    
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null || !auth.isAuthenticated()) {
            throw new ProductsException("Usuário não autenticado");
           
        }
        UserModel loggedUser = (UserModel) auth.getPrincipal();
        
        products.setUserModel(loggedUser);
        return productsRepository.save(products);
    }


    public UserModel getUser(String email){
        
      return userRepository.findByEmail(email).orElse(null);
    
    }


    public Products updateProducts(Long code, Products products){

        Products productsExist = productsRepository.findById(code)
            .orElseThrow(() ->
             new ResourceNotFoundException("Produto não encontrado com ID: " + code));

        productsExist.setQuantityStock(products.getQuantityStock());
        
        return productsRepository.save(productsExist);
    }
    
    public void removeProducts(Long code){

        Products productsExist = productsRepository.findById(code)
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com ID: " + code));

        productsRepository.delete(productsExist);
    }
 




}
