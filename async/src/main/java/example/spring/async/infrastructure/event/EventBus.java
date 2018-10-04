package example.spring.async.infrastructure.event;

import example.spring.async.domain.model.Product;
import example.spring.async.infrastructure.email.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EventBus {

    final EmailService emailService;

    public void handleSuccessPayment(List<Product> products) {
        emailService.sendMessage(products);
    }
}
