package ru.microservice.gbcartcreater.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import ru.microservice.gbcartcreater.entity.Product;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDto {
    @JsonProperty(value="cartId")
    private Long id;

    private String status= "not empty";

    private List<ProductDto> products;

}
