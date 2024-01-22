package api.ecommerce.br.apiecommerce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.ecommerce.br.apiecommerce.model.Brand;
import api.ecommerce.br.apiecommerce.repository.BrandRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service

public class BrandService {
    
    @Autowired
    private BrandRepository brandRepository;

    private final Logger logger = LoggerFactory.getLogger(BrandService.class);

    // @Transactional()
    public List<String> getNameCategoryByBrand(String category){
        List<Brand> brands = brandRepository.findByCategory("cigarrets");

        // if(brands == null){
        //     throw new RuntimeException("Marca nula");
        // }
        logger.info("Número de registros encontrados: {}", brands.size());

        return brands.stream()
                    .map(Brand::getName)
                    .collect(Collectors.toList());
    }
}
//     public List<String> findAll(){
//         List<Brand> find = brandRepository.findBrands();
//         return find;
//     }
// }
