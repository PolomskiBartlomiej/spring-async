package example.spring.async.app;

import example.spring.async.domain.model.Product;
import example.spring.async.domain.service.CartService;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Value
@RestController
@RequestMapping("/product")
class CartController {

    CartService cartService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void buyProducts(List<Product> products) {
        cartService.buyProducts(products);
    }
}
