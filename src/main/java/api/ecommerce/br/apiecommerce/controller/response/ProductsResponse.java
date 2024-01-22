package api.ecommerce.br.apiecommerce.controller.response;

import java.util.ArrayList;
import java.util.List;

import api.ecommerce.br.apiecommerce.model.Brand;
import api.ecommerce.br.apiecommerce.model.Model;
import api.ecommerce.br.apiecommerce.model.Products;
import api.ecommerce.br.apiecommerce.model.ShoppingCartModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsResponse {
    
    private Long id;

    private int quantityStock;

    private int quantityProducts;

    private Double unitaryValue;

    private List<ShoppingCartModel> shoppingCart;

    private String brandName;

    private List<Model> modelName;

    public ProductsResponse(Products products){
        this.id = products.getId();
        this.quantityStock = products.getQuantityStock();
        this.unitaryValue = products.getUnitaryValue();
        this.brandName = products.getBrand().getName();
        this.modelName = new ArrayList<>();

            products.getBrand().getModels().forEach(models ->{
                Model model = new Model();
                model.setName(models.getName());
                this.modelName.add(model);
            });
    }
    

}
