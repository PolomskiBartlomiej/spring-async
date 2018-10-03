package example.spring.async.infrastructure.email;

import example.spring.async.infrastructure.context.Context;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;

@Async
@RequiredArgsConstructor
public class EmailService {

    private final EmailSender emailSender;
    private final Context context;

    public void sendMessage(String massage) {
        emailSender.send(massage, context.getEmail())
                   .whenComplete((aVoid, throwable) ->
                                    System.out.println("Error while sending massage cause : "
                                                        + throwable.getLocalizedMessage()));
    }
}
