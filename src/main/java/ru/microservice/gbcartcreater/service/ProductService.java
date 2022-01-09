package ru.microservice.gbcartcreater.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.microservice.gbcartcreater.dao.ProductDao;
import ru.microservice.gbcartcreater.dto.ProductDto;
import ru.microservice.gbcartcreater.dto.mapper.ProductMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductDao productDao;
    private final ProductMapper productMapper;



    @Transactional(readOnly = true)
    public ProductDto findById(Long id) {
        return productMapper.toProductDto(productDao.findById(id).orElse(null));
    }

    public List<ProductDto> findAll() {
        return productDao.findAll().stream()
                .map(productMapper::toProductDto)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        try {
            productDao.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error("No such id in DB: " + e.getMessage());
        }
    }

}
