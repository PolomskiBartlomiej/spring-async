package example.spring.async.infrastructure.email;

import example.spring.async.domain.model.Product;
import example.spring.async.infrastructure.context.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;
@Slf4j
@Async("emailExecutor")
@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailSender emailSender;
    private final User user;

    public void sendMessage(List<Product> products) {
        log.info("Start email process");
        emailSender.send("Ready for pickup " + products.toString(), user.getEmail())
                   .whenComplete((aVoid, throwable) -> {
                       Throwable cause = isNull(throwable.getCause())
                               ? throwable
                               : throwable.getCause();
                               log.info("Error while sending massage cause", cause);
                   });
    }
}
