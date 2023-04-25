package api.ecommerce.br.apiecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


import api.ecommerce.br.apiecommerce.model.UserModel;
import api.ecommerce.br.apiecommerce.service.UserService;


@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/home")  
  public ResponseEntity<String> homeUser() {
    return ResponseEntity.ok("Hello user");
  }

  @PostMapping("/products")
  public ResponseEntity<String> productsUser(){
    return ResponseEntity.ok("produtos");
  }

  @PutMapping("update/{email}")
  public ResponseEntity<UserModel> updateUserEmail(@PathVariable("email") String email, @RequestBody UserModel updadeUserModel) {
    
    try {
      UserModel updateUser = userService.updateEmail(email, updadeUserModel);
      return ResponseEntity.ok(updateUser); 


    } catch (UsernameNotFoundException e) {
      return ResponseEntity.notFound().build();

    } 
    
    
  }

}
