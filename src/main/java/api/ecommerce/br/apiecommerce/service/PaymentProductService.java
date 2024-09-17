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
import api.ecommerce.br.apiecommerce.exception.ResourceNotFoundException;
import api.ecommerce.br.apiecommerce.model.PaymentProduct;
import api.ecommerce.br.apiecommerce.model.Product;
import api.ecommerce.br.apiecommerce.repository.PaymentRepository;
import api.ecommerce.br.apiecommerce.repository.ProductsRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentProductService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentProduct paymentProduct;

    @Autowired
    private VerifyAuthentication auth;
    
    public List<PaymentProduct> listProducts() {
        return this.paymentRepository.findAll();
    }

    double sum = 0.0;

    public PaymentProduct createPayment(List<Product> products, String methodPayment) {
        if (auth.verifyUserIsAuthenticated()) {

            paymentProduct.setCurrentDate(LocalDateTime.now());
            
            products.stream().forEach( m-> {
            
                sum += m.getUnitaryValue() * m.getQuantityStock() ;
            });
            
            //12% tax to products
            paymentProduct.setTax(sum * 1.12);
            paymentProduct.setAmountValue(sum);
            paymentProduct.setPaymentMethod(methodPayment);

            PaymentProduct paymentProductsSave = paymentRepository.save(paymentProduct);

            return paymentProductsSave;
        }
        return null;

    }

    public PaymentProduct updateProducts(String id, PaymentProduct payment) {

        if (auth.verifyUserIsAuthenticated()) {
            PaymentProduct paymentProduct = paymentRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com ID: " + id));

            //paymentProduct.setQuantityStock(payment.getQuantityStock());

            return paymentRepository.save(paymentProduct);
        }
        
        return null;
    }

    public void removeProduct(String id) {
    
        if (auth.verifyUserIsAuthenticated() && auth.verifyIsAdminRole()) {
            PaymentProduct paymentProduct = paymentRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com ID: " + id));

            paymentRepository.delete(paymentProduct);
        }

    }

}