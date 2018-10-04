package example.spring.async.app.message;

import example.spring.async.domain.model.Product;
import lombok.Value;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Value
public class ProductDto implements Serializable {
    List<Product> products;

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
}
