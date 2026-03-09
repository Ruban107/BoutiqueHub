package com.boutique.boutiquehub.service;

import com.boutique.boutiquehub.entity.Cart;

import java.util.List;

public interface CartService {

//    •	addToCart(Long userId, Long sareeId, int quantity)
//•	updateCartQuantity(Long cartId, int quantity)
//•	removeFromCart(Long cartId)
//•	getUserCart(Long userId)

    Cart addCart(Cart cart);
    Cart updateCartQuantity(long cartID, int quantity);
    void removeFromCart(long cartId);
    List<Cart> getUserCart(long userId);

}
