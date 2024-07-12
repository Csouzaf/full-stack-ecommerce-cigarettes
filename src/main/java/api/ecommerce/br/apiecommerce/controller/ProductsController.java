package api.ecommerce.br.apiecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import api.ecommerce.br.apiecommerce.controller.response.ProductsResponse;
import api.ecommerce.br.apiecommerce.model.Products;
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
    public ResponseEntity<Products> createProducts(@RequestBody Products products){


        Products createProducts = productsService.createProducts(products);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(createProducts);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Products> updateProducts(@PathVariable Long id, @PathVariable Products products){

        return ResponseEntity.ok(productsService.updateProducts(id, products));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Products> deleteProducts(@PathVariable Long id){
        
        productsService.removeProducts(id);
        return ResponseEntity.noContent().build();
    }
}
