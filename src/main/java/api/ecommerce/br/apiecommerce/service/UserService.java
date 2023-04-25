package api.ecommerce.br.apiecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import api.ecommerce.br.apiecommerce.model.UserModel;
import api.ecommerce.br.apiecommerce.repository.UserRepository;

public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public UserModel updateEmail(String email, UserModel userModel){
        
        UserModel userEmail = userRepository.findByEmail(email);

        if(userEmail == null) {
            throw new UsernameNotFoundException("Usuário não encontrado pelo email" + email);
        }
        
        else {
            userEmail.setEmail(userModel.getEmail());
        }

        return userRepository.save(userModel);
    }


}
