package ru.microservice.gbcartcreater.dto.mapper;

import org.mapstruct.Mapper;
import ru.microservice.gbcartcreater.dto.CartDto;
import ru.microservice.gbcartcreater.entity.Cart;


@Mapper(uses = ProductMapper.class)
public interface CartMapper {

    Cart toCart(CartDto cartDto);
    CartDto toCartDto(Cart cart);

}
