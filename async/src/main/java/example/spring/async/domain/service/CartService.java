package example.spring.async.domain.service;

import example.spring.async.domain.model.Product;
import example.spring.async.domain.port.ProductPayment;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Value
@Service
public class CartService {

    ProductPayment productPayment;

    public void buyProducts(List<Product> products) {
        productPayment.toPayment(products);
    }
}
