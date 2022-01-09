package ru.microservice.gbcartcreater.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import ru.microservice.gbcartcreater.entity.Cart;

public interface CartDao  extends JpaRepository<Cart, Long> {


}
