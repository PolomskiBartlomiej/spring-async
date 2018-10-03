package example.spring.async.app;

import example.spring.async.app.message.ProductDto;
import example.spring.async.domain.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
class CartController {

    final CartService cartService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void buyProducts(ProductDto productDto) {
        cartService.buyProducts(productDto.getProducts());
    }
}
