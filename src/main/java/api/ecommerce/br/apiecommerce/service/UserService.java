package api.ecommerce.br.apiecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import api.ecommerce.br.apiecommerce.model.UserAnwserModel;
import api.ecommerce.br.apiecommerce.model.UserModel;
import api.ecommerce.br.apiecommerce.repository.UserRepository;

@Service
public class UserService {
    

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserAnwserModel messageUser;
  
    public UserModel verifyAndCreateUser(UserModel userModel){
       

            Optional<UserModel> verifyUserExist = userRepository.findByEmail(userModel.getEmail());

            if (verifyUserExist.isPresent()) {

                ResponseEntity.badRequest().body("Email already exists, try other");
            }   
          
               
               
                return userRepository.save(userModel);

              
         
    }
}
