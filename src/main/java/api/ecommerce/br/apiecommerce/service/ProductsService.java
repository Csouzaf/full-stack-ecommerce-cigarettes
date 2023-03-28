package api.ecommerce.br.apiecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.ecommerce.br.apiecommerce.exception.ResourceNotFoundException;
import api.ecommerce.br.apiecommerce.model.Products;
import api.ecommerce.br.apiecommerce.repository.ProductsRepository;

@Service
public class ProductsService {
    
    @Autowired
    private ProductsRepository productsRepository;

    public Products createProducts(Products products){
       return productsRepository.save(products); 
    }

    public Products updateProducts(Long code, Products update){

        Products productsExist = productsRepository.findById(code)
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com ID: " + code));

        productsExist.setQuantity(update.getQuantity());
        
        return productsRepository.save(productsExist);
    }
    
    public void removeProducts(Long code){

        Products productsExist = productsRepository.findById(code)
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com ID: " + code));

        productsRepository.delete(productsExist);
    }
 




}
