package api.ecommerce.br.apiecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/user")
public class UserController {

  
  @GetMapping("/home")  
  public ResponseEntity<String> homeUser() {
    return ResponseEntity.ok("Hello user");
  }

  @PostMapping("/products")
  public ResponseEntity<String> productsUser(){
    return ResponseEntity.ok("produtos");
  }
}
