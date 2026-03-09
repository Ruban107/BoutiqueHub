package com.boutique.boutiquehub.controller;


import com.boutique.boutiquehub.entity.Cart;
import com.boutique.boutiquehub.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController  {

    @Autowired
    private CartService cartService;

    @PostMapping
    public Cart addCart(@RequestBody Cart cart){
        return cartService.addCart(cart);
    }

    @GetMapping("/{id}")
    public List<Cart> getCartByUser(@PathVariable long userId){
        return cartService.getUserCart(userId);
    }

    @DeleteMapping("/{id}")
    public String deleteCart(@PathVariable long cartId){
        cartService.removeFromCart(cartId);
        return "deleted sucessfully";
    }

    @PutMapping("/{id}")
    public Cart updateCart(@PathVariable long cartId,@RequestBody Cart cart){
        return cartService.updateCartQuantity(cartId,cart.getQuantity());
    }
}
