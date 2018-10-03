package example.spring.async.infrastructure.async;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync
@Configuration
public class AsyncConfiguration  {

    @Qualifier("email")
    @Bean("emailExecutor")
    public Executor emailExecutor() {
        return new ThreadPoolTaskExecutor();
    }

    @Qualifier("payment")
    @Bean("paymentExecutor")
    public Executor paymentExecutor() {
        return new ThreadPoolTaskExecutor();
    }
}
