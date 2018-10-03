package example.spring.async.infrastructure.payment;

import example.spring.async.domain.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class PaymentAPI {
    String pay(List<Product> products) {
        if (products.size() > 1) return "Accept";
        throw new IllegalArgumentException();

    }
}
