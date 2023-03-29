package api.ecommerce.br.apiecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import api.ecommerce.br.apiecommerce.model.Products;
import api.ecommerce.br.apiecommerce.service.ProductsService;

@RestController
public class ProductsController {
    
    @Autowired
    private ProductsService productsService;

    @GetMapping("/list")
    public Iterable<Products> listproducts(){
        return productsService.listProducts();
    }

    @PostMapping("/create")
    public ResponseEntity<Products> createProducts(@RequestBody Products products){

        return ResponseEntity.status(HttpStatus.CREATED).body(productsService.createProducts(products));
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
