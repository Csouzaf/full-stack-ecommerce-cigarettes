package api.ecommerce.br.apiecommerce.exception;

public class ProductsException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    
    public ProductsException(String message){
        super(message);
    }

    public ProductsException(String message, Throwable cause){
        super(message, cause);
    }



}
