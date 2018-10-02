package example.spring.async.infrastructure.event;

import example.spring.async.domain.model.Product;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

@Async
@Component
public class EventBus {

    EmailService emailService;

    public void handle(PaymentEvent paymentEvent, List<Product> products) {
        final String massage;
        switch (paymentEvent) {
             case ACCEPT:
                 massage = "Accept " + products.toString(); break;
             case REJECTED:
                 massage = "Sorry payment rejected for " + products.toString();
         }

        emailService.sendMessage(massage)
    }
}
