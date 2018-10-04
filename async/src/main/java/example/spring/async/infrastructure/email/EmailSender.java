package example.spring.async.infrastructure.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Slf4j
@Async("emailExecutor")
@Component
class EmailSender {

    private final Executor emailExecutor;

    public EmailSender(@Qualifier("email") Executor emailExecutor) {
        this.emailExecutor = emailExecutor;
    }

    public CompletableFuture<Void> send(String massage, String email) {
       return CompletableFuture
                .runAsync(() -> log.info("Send email to : " + email
                                        +" with massage : " + massage),
                        emailExecutor);
    }
}
