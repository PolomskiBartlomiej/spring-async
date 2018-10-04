package example.spring.async.domain.service;

import example.spring.async.domain.model.PaymentStatusEnum;
import example.spring.async.domain.model.Product;
import example.spring.async.domain.port.ProductPayment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    final ProductPayment productPayment;

    public PaymentStatusEnum buyProducts(List<Product> products) {
       return productPayment.toPayment(products).join();
    }
}
