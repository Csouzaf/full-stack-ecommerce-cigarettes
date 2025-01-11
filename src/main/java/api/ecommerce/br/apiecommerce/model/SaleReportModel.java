package api.ecommerce.br.apiecommerce.model;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleReportModel {
	
	 
	    private int quantityStock;

	  
	    private String nameProduct;


	    private int quantityProducts;
	    
	
	    private Brand brand;
	    
	
	    private Model model;
	    
	    
	    private LocalDateTime dateTime;
}
