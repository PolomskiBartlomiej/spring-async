package example.spring.async.infrastructure.email;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Async("emailExecutor")
@Component
class EmailSender {

    private final Executor emailExecutor;

    public EmailSender(@Qualifier("email") Executor emailExecutor) {
        this.emailExecutor = emailExecutor;
    }

    public CompletableFuture<Void> send(String massage, String email) {
       return CompletableFuture
                .runAsync(() -> System.out.println("Send : " + massage), emailExecutor);
    }
}
