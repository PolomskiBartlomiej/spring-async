package example.spring.async.infrastructure.payment;

import example.spring.async.domain.model.PaymentStatusEnum;
import example.spring.async.domain.model.Product;
import example.spring.async.domain.port.ProductPayment;
import example.spring.async.infrastructure.event.EventBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static java.util.Objects.nonNull;

@Async("paymentExecutor")
@Slf4j
@Service
class ProductPaymentService implements ProductPayment {

   private final Executor paymentExecutor;
   private final PaymentAPI paymentAPI;
   private final EventBus eventBus;

    public ProductPaymentService(@Qualifier("payment") Executor paymentExecutor, PaymentAPI paymentAPI, EventBus eventBus) {
        this.paymentExecutor = paymentExecutor;
        this.paymentAPI = paymentAPI;
        this.eventBus = eventBus;
    }

    @Override
    public CompletableFuture<PaymentStatusEnum> toPayment(final List<Product> products) {

        return CompletableFuture
                .supplyAsync(() -> paymentAPI.pay(products), paymentExecutor)
                .thenApply(result -> PaymentStatusEnum.ACCEPT )
                .whenComplete((result, ex) -> {
                                if(nonNull(result))
                                eventBus.handleSuccessPayment(products);
                              }
                )
                .exceptionally(ex -> {
                              Throwable throwable = nonNull(ex.getCause())
                                      ? ex.getCause()
                                      : ex;
                              log.error("Payment failed by", throwable);

                              return PaymentStatusEnum.REJECTED; });
    }
}
