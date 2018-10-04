package example.spring.async.domain.model;

import lombok.Value;

@Value
public class Product {
    Integer id;
    Integer customerId;

    @Override
    public String toString() {
        return "Product id=" + id ;
    }
}
