package api.ecommerce.br.apiecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import api.ecommerce.br.apiecommerce.model.UserModel;
import api.ecommerce.br.apiecommerce.repository.UserUpdateDeleteRepository;

@Service
public class UserService {
    
    @Autowired
    private UserUpdateDeleteRepository userUpdateDeleteRepository;
    
    public UserModel updateEmail(String email, UserModel userModel){
        
         UserModel userEmail = userUpdateDeleteRepository.findByEmail(email);

        if(userEmail == null) {
            throw new UsernameNotFoundException("Usuário não encontrado pelo email: " + email);
        }
        
        else {
            userEmail.setEmail(userModel.getEmail());
        }

        return userUpdateDeleteRepository.save(userEmail);
    }


}
