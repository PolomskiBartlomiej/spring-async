package example.spring.async.infrastructure.context;

import org.springframework.stereotype.Component;

@Component
public class User {

    public String getEmail() {
        return "email@emial.com";
    }
}
