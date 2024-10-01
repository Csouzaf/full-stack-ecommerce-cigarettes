package api.ecommerce.br.apiecommerce.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import api.ecommerce.br.apiecommerce.config.auth.AuthenticationRequest;
import api.ecommerce.br.apiecommerce.config.auth.AuthenticationService;
import api.ecommerce.br.apiecommerce.config.auth.VerifyAuthentication;
import api.ecommerce.br.apiecommerce.enums.PaymentMethod;
import api.ecommerce.br.apiecommerce.exception.ResourceNotFoundException;
import api.ecommerce.br.apiecommerce.model.Favorite;
import api.ecommerce.br.apiecommerce.model.OrderPaymentProduct;
import api.ecommerce.br.apiecommerce.model.PaymentProduct;
import api.ecommerce.br.apiecommerce.model.Product;
import api.ecommerce.br.apiecommerce.model.UserModel;
import api.ecommerce.br.apiecommerce.repository.FavoriteRepository;
import api.ecommerce.br.apiecommerce.repository.PaymentRepository;
import api.ecommerce.br.apiecommerce.repository.ProductsRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FavoriteService {

    
    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private ProductsRepository productRepository;

    @Autowired
    private VerifyAuthentication auth;

    public List<Favorite> listProducts(int userId) {
    	 if (auth.verifyUserIsAuthenticated()) {
    		 
    		 return this.favoriteRepository.findByUserModel(userId);
    		 
    	 }
        return null;
    }
    
    public Favorite create(Product product) {

        if (auth.verifyUserIsAuthenticated()) {
        	
        	Favorite favorite = new Favorite();
        	       	
        	UserModel user = auth.userAuthenticated();
        	
        	favorite.setUserModel(user);
        	favorite.setProduct(product);
        	
            return favoriteRepository.save(favorite);
        }

        return null;
    }
    

    public void remove(Long id) {

        if (auth.verifyUserIsAuthenticated()) {
        	 Favorite favorite = favoriteRepository.findById(id)
                     .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com ID: " + id));
            
        	 favoriteRepository.delete(favorite);
        }

    }

}