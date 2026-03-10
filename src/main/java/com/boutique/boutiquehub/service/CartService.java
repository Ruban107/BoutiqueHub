package com.boutique.boutiquehub.service;

import com.boutique.boutiquehub.entity.Cart;

import java.util.List;

public interface CartService {

    Cart addCart(Cart cart);
    Cart updateCartQuantity(long cartID, int quantity);
    void removeFromCart(long cartId);
    List<Cart> getUserCart(long userId);

}
