// package api.ecommerce.br.apiecommerce.service;

// import java.util.Optional;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;
// import api.ecommerce.br.apiecommerce.model.UserModel;
// import api.ecommerce.br.apiecommerce.repository.UserRepository;

// @Service
// public class UserService   {
    

//     @Autowired
//     private UserRepository userRepository;
    
    
   

//     public UserModel verifyAndCreateUser(UserModel userModel) {
       

//             Optional<UserModel> verifyUserExist = userRepository.findByEmail(userModel.getEmail());

//             if (verifyUserExist.isPresent()) {

//                 ResponseEntity.badRequest().body("Email already exists, try other");
//             }   
          
//                 // PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//                 // String senhaCriptografada = passwordEncoder.encode(userModel.getPassword());
//                 // userModel.setPassword(senhaCriptografada);
//                 return userRepository.save(userModel);

//     }

//     // @Override
//     // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//     //     // TODO Auto-generated method stub
//     //     throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
//     // }

  
// }
