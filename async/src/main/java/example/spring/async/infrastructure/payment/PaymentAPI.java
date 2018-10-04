package example.spring.async.infrastructure.payment;

import example.spring.async.domain.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
class PaymentAPI {
    String pay(List<Product> products) {
        if (products.size() > 1) {
            log.error("Payment rejected for products :" + products.toString());
            throw new PaymentException();
        }
        log.info("Payment accept for products :" + products.toString());
        return "Accept";
    }
}
