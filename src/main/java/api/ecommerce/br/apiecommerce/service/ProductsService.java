package api.ecommerce.br.apiecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import api.ecommerce.br.apiecommerce.config.auth.AuthenticationRequest;
import api.ecommerce.br.apiecommerce.config.auth.AuthenticationService;
import api.ecommerce.br.apiecommerce.config.jwt.ApplicationConfig;
import api.ecommerce.br.apiecommerce.exception.ProductsException;
import api.ecommerce.br.apiecommerce.exception.ResourceNotFoundException;
import api.ecommerce.br.apiecommerce.model.Products;

import api.ecommerce.br.apiecommerce.model.UserEmail;
import api.ecommerce.br.apiecommerce.model.UserModel;
import api.ecommerce.br.apiecommerce.repository.ProductsRepository;

import api.ecommerce.br.apiecommerce.repository.UserEmailRepository;
import api.ecommerce.br.apiecommerce.repository.UserRepository;
import jakarta.validation.constraints.Email;

@Service
public class ProductsService {
    
    @Autowired
    private ProductsRepository productsRepository;
    
    @Autowired
    private UserRepository userRepository;


    public Iterable<Products> listProducts(){
        return productsRepository.findAll();
    }

   
    public Products createProducts(Products products, Authentication authentication){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null && !authentication.isAuthenticated()) {
            throw new ProductsException("Usuário não autenticado");
           
        }
       Products productsSaved = productsRepository.save(products);
        return productsSaved;
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
