package api.ecommerce.br.apiecommerce.service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import api.ecommerce.br.apiecommerce.model.UserModel;
import api.ecommerce.br.apiecommerce.repository.UserRepository;
import api.ecommerce.br.apiecommerce.repository.UserUpdateDeleteRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    
    private UserRepository userRepository;
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

    public String getFullName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.isAuthenticated()) {
        
                String username = authentication.getName();
                return username;
            }
            else{
                throw new UsernameNotFoundException("Name is not possible because user is not authenticated");
            }
       
    
    }
}
