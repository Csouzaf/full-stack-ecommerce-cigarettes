package api.ecommerce.br.apiecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import api.ecommerce.br.apiecommerce.controller.response.ProductsResponse;
import api.ecommerce.br.apiecommerce.model.Product;
import api.ecommerce.br.apiecommerce.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {
    
    @Autowired
    private ProductsService productsService;

    @GetMapping()
    public ResponseEntity<List<ProductsResponse>> listproducts(){

        List<ProductsResponse> productsResponses = new ArrayList<>();

        productsService.listProducts().forEach(products -> {
            productsResponses.add(new ProductsResponse(products));
            });
            
        return ResponseEntity.ok().body(productsResponses);
    }

    @PostMapping()
    public ResponseEntity<Product> createProducts(@RequestBody Product products){


        Product createProducts = productsService.createProducts(products);

        if (createProducts == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(createProducts);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProducts(@PathVariable Long id, @PathVariable Product products){

        return ResponseEntity.ok(productsService.updateProducts(id, products));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProducts(@PathVariable Long id){
        
        productsService.removeProducts(id);
        return ResponseEntity.noContent().build();
    }
}
