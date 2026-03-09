package com.boutique.boutiquehub.serviceimpl;

import com.boutique.boutiquehub.entity.Cart;
import com.boutique.boutiquehub.repository.CartRepository;
import com.boutique.boutiquehub.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateCartQuantity(long cartID, int quantity) {
        Cart existing = cartRepository.findById(cartID).orElse(null);
        if(existing != null){
            existing.setQuantity(quantity);
        }
        return  cartRepository.save(existing);

    }

    @Override
    public void removeFromCart(long cartId) {
        cartRepository.deleteById(cartId);
    }
}
