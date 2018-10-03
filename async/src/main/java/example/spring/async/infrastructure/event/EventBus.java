package example.spring.async.infrastructure.event;

import example.spring.async.domain.model.Product;
import example.spring.async.infrastructure.email.EmailService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EventBus {

    final EmailService emailService;

    public void handle(@NonNull PaymentEvent paymentEvent, List<Product> products) {
        final String massage;
        switch (paymentEvent) {
             case ACCEPT:
                 massage = "Accept payment for products : " + products.toString();
                 break;
             case REJECTED:
                 massage = "Payment rejected for products : " + products.toString();
                 break;
             default:
                 throw new IllegalArgumentException(paymentEvent.toString());
         }

        emailService.sendMessage(massage);
    }
}
