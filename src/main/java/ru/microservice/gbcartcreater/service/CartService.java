package ru.microservice.gbcartcreater.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.microservice.gbcartcreater.dao.CartDao;
import ru.microservice.gbcartcreater.dto.CartDto;
import ru.microservice.gbcartcreater.dto.mapper.CartMapper;
import ru.microservice.gbcartcreater.dto.mapper.ProductMapper;
import ru.microservice.gbcartcreater.entity.Cart;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {

    private final CartDao cartDao;
    private final CartMapper cartMapper;
    private final ProductMapper productMapper;
    private Cart cart;

    public CartDto findById(Long id) {
//        return cartDao.findCartsById(id);
       return  cartMapper.toCartDto(cartDao.findById(id).orElse(null));
    }


    public void deleteById(Long id) {
        try {
            cartDao.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error("No such id in DB: " + e.getMessage());
        }
    }


//    public Cart save(Long id, ProductDto productDto) {
//        List<Product> productList;
//        Product product=productMapper.toProduct(productDto);
//
//
//        }
//

//        if (cart.getId() != null) {
//            Optional<Cart> cartOptional = cartDao.findById(cart.getId());
//            if (cartOptional.isPresent()) {
//                Cart cartFromDB = cartOptional.get();
//                cartFromDB.setProducts(cart.getProducts());
//                return cartDao.save(cartFromDB);
//            }
//        }
//        return cartDao.save(cart);

//    }



}
