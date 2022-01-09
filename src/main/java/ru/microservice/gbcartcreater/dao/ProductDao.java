package ru.microservice.gbcartcreater.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.microservice.gbcartcreater.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao extends JpaRepository<Product, Long> {


}
