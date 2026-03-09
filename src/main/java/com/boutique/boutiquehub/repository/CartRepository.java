package com.boutique.boutiquehub.repository;

import com.boutique.boutiquehub.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
