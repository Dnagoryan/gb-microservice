package ru.microservice.gbcartcreater.rest;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.microservice.gbcartcreater.dto.CartDto;
import ru.microservice.gbcartcreater.dto.ProductDto;
import ru.microservice.gbcartcreater.dto.mapper.CartMapper;
import ru.microservice.gbcartcreater.dto.mapper.ProductMapper;
import ru.microservice.gbcartcreater.entity.Cart;
import ru.microservice.gbcartcreater.entity.Product;
import ru.microservice.gbcartcreater.service.CartService;
import ru.microservice.gbcartcreater.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {

    private  Cart cart = Cart.builder().build();
    private final CartService cartService;


    private final CartMapper cartMapper;



    @GetMapping("/{cartId}")
    @PostMapping(produces = "application/json;charset=UTF-8",
            consumes = "application/json;charset=UTF-8")
    public ResponseEntity<?> getCartList(@PathVariable("cartId") Long cartId) {
        Optional<Cart> cartOptional = Optional.ofNullable(cartMapper.toCart(cartService.findById(cartId)));
        if (cartOptional.isPresent()) {
    //            cart.setProducts(cartOptional.get().getProducts());
            cart.setProducts(cartOptional.get().getProducts());
            cart.setId(cartId);
            return new ResponseEntity<>(cart, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //здесь должна быть  юзер и проверка на принадлежность юзера к корзинам(не знаю надо ли создавать новую корзину)
//    @PostMapping   ("/{cartId}")
//    public ResponseEntity<?> handlePost(@Validated @RequestBody ProductDto productDto, @PathVariable("cartId") Long id) {
//        Cart
//        }

//        List<Product> productList;
//        Product product =productMapper.toProduct(productService.findById(productDto.getId()));
//        if (cart.getId() == null) {
//            productList = new ArrayList<>();
//            productList.add(product);
//            cart.setProducts(productList);
//            Cart cartFromDb = cartService.save(cart);
//            cart.setId(cartFromDb.getId());
//            return new ResponseEntity<>(cart, HttpStatus.CREATED);
//        } else {
//            Cart cartFromDb = cartService.findById(cart.getId());
//            productList = cartFromDb.getProducts();
//            productList.removeIf(product1 -> product1.getId().equals(productDto.getId()));
//            productList.add(product);
//            cart.setProducts(productList);
//            cartService.save(cart);
//            return new ResponseEntity<>(cart, HttpStatus.OK);
//        }
//    }

//    @DeleteMapping("/{cartId}")
//    public ResponseEntity<?> handleUpdate(@PathVariable("cartId") Long id,
//                                          @Validated @RequestBody ProductDto productDto) {
//        Optional<Cart> cartOptional = Optional.ofNullable(cartService.findById(id));
//        if (cartOptional.isPresent()) {
//            cart.setProducts(cartOptional.get().getProducts());
//            cart.getProducts().removeIf(product -> product.getId().equals(productDto.getId()));
//            cartService.save(cart);
//            return new ResponseEntity<>(cart, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//    }

}


