package com.boutique.boutiquehub.serviceimpl;

import com.boutique.boutiquehub.entity.Cart;
import com.boutique.boutiquehub.entity.User;
import com.boutique.boutiquehub.repository.CartRepository;
import com.boutique.boutiquehub.repository.UserRepository;
import com.boutique.boutiquehub.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

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

    @Override
    public List<Cart> getUserCart(long userId){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // fetch cart items
        List<Cart> cartItems = cartRepository.findByUserId(userId);

        return cartItems;
    }
}
