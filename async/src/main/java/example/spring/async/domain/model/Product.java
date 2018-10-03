package example.spring.async.domain.model;

import lombok.ToString;
import lombok.Value;

@Value
@ToString
public class Product {
    long id;
    long customerId;
}
