package com.boutique.boutiquehub.serviceimpl;
import com.boutique.boutiquehub.entity.User;
import com.boutique.boutiquehub.repository.UserRepository;
import com.boutique.boutiquehub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User getUserById(long id) {

        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email).orElse(null);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User updateUser(long id, User user) {
        User existing = userRepo.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(user.getName());
            existing.setEmail(user.getEmail());

        }
        return userRepo.save(existing);
    }

    @Override
    public void deleteUserById(long id) {
        userRepo.deleteById(id);
    }
}


