package api.ecommerce.br.apiecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import api.ecommerce.br.apiecommerce.model.Brand;
import api.ecommerce.br.apiecommerce.service.BrandService;
import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;


 

    @GetMapping("/{category}")
    public List<String> getNameCategoryByBrand(@PathVariable String category){
        return brandService.getNameCategoryByBrand(category);
    }
}
