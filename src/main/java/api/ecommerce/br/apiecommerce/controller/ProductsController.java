package api.ecommerce.br.apiecommerce.controller;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import api.ecommerce.br.apiecommerce.config.auth.AuthenticationRequest;
import api.ecommerce.br.apiecommerce.model.Products;
import api.ecommerce.br.apiecommerce.service.ProductsService;


@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
     private ProductsService productsService;

    @GetMapping()
    public Iterable<Products> listproducts(){
        return productsService.listProducts();
    }

    @PostMapping("/create")
    public ResponseEntity<Products> createProducts(@RequestBody Products products, Authentication authentication){

        Products createProducts = productsService.createProducts(products, authentication);
        
        if(createProducts != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createProducts);
        } 
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        
    
    }

    @PutMapping("/update/{code}")
    public ResponseEntity<Products> updateProducts(@PathVariable Long code, @PathVariable Products products){

        return ResponseEntity.ok(productsService.updateProducts(code, products));
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<Products> deleteProducts(@PathVariable Long code){
        
        productsService.removeProducts(code);
        return ResponseEntity.noContent().build();
    }
}
