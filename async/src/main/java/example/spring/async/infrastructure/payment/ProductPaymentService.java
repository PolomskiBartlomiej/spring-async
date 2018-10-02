package example.spring.async.infrastructure.payment;

import example.spring.async.domain.model.PaymentStatusEnum;
import example.spring.async.domain.model.Product;
import example.spring.async.domain.port.ProductPayment;
import example.spring.async.infrastructure.event.EventBus;
import example.spring.async.infrastructure.event.PaymentEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static java.util.Objects.nonNull;

@Async
@Service
@RequiredArgsConstructor
class ProductPaymentService implements ProductPayment {

   @Qualifier("payment")
   private final Executor paymentExecutor;
   private final PaymentAPI paymentAPI;
   private final EventBus eventBus;

    @Override
    public CompletableFuture<PaymentStatusEnum> toPayment(final List<Product> products) {

        return CompletableFuture
                .supplyAsync(() -> paymentAPI.pay(products), paymentExecutor)
                .thenApply(PaymentAssembler::toPaymentStatus)
                .whenComplete((result, ex) -> {
                                PaymentEvent paymentEvent = nonNull(result) ?
                                PaymentEvent.ACCEPT : PaymentEvent.REJECTED;
                                eventBus.handle(paymentEvent,products);
                         })
                .exceptionally(ex -> PaymentStatusEnum.REJECTED);
    }
}
