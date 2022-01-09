package ru.microservice.gbcartcreater.dto.mapper;


import org.mapstruct.Mapper;
import ru.microservice.gbcartcreater.dto.ProductDto;
import ru.microservice.gbcartcreater.entity.Product;

@Mapper
public interface ProductMapper {

    Product toProduct(ProductDto productDto);

    ProductDto toProductDto(Product product);

}
