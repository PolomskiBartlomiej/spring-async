package example.spring.async.app;

import example.spring.async.app.message.ProductDto;
import example.spring.async.domain.model.PaymentStatusEnum;
import example.spring.async.domain.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
class CartController {

    final CartService cartService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PaymentStatusEnum buyProducts(@RequestBody ProductDto productDto) {
       return cartService.buyProducts(productDto.getProducts());
    }
}
