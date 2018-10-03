package example.spring.async.infrastructure.context;

import org.springframework.stereotype.Component;

@Component
public class Context {

    public String getEmail() {
        return "email";
    }
}
