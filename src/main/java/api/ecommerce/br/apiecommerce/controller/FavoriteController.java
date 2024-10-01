package api.ecommerce.br.apiecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import api.ecommerce.br.apiecommerce.controller.response.ProductsResponse;
import api.ecommerce.br.apiecommerce.model.Favorite;
import api.ecommerce.br.apiecommerce.model.Product;
import api.ecommerce.br.apiecommerce.service.FavoriteService;
import api.ecommerce.br.apiecommerce.service.ProductsService;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {
    
    @Autowired
    private FavoriteService favoriteService;

    @GetMapping()
    public ResponseEntity<List<Favorite>> listproducts(int userId){

        return ResponseEntity.ok().body(favoriteService.listProducts(userId));
    }

    @PostMapping()
    public ResponseEntity<Favorite> create(@RequestBody Product products){


        Favorite createFavoriteFromProducts = favoriteService.create(products);

        if (createFavoriteFromProducts == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(createFavoriteFromProducts);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProducts(@PathVariable Long id){
        
    	favoriteService.remove(id);
        return ResponseEntity.noContent().build();
    }
}
