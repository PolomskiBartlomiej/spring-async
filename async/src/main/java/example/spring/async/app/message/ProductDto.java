package example.spring.async.app.message;

import example.spring.async.domain.model.Product;
import lombok.Value;

import java.util.List;

@Value
public class ProductDto {
    List<Product> products;
}
