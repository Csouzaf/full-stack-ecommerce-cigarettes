package api.ecommerce.br.apiecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.ecommerce.br.apiecommerce.model.UserModel;


@RestController
@RequestMapping("/api/user")
public class UserController {
    
  @GetMapping  
  public ResponseEntity<String> homeUser() {
    return ResponseEntity.ok("Hello user");
  }
}
