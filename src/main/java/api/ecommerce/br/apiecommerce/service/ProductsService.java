package api.ecommerce.br.apiecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import api.ecommerce.br.apiecommerce.model.Products;
import api.ecommerce.br.apiecommerce.repository.ProductsRepository;

@Service
public class ProductsService {
    
    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private Products productsModel;



    private final Double dunhillRed = 11.50;
    
    
    private final Double dunhillBlue = 11.50;
    

    
    
 




}
