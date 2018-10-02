package example.spring.async.domain.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Product {

    private long id;
    private long customerId;
}
