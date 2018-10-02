package example.spring.async.domain.port;

import example.spring.async.domain.model.PaymentStatusEnum;
import example.spring.async.domain.model.Product;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ProductPayment {
    CompletableFuture<PaymentStatusEnum> toPayment(List<Product> products);
}
