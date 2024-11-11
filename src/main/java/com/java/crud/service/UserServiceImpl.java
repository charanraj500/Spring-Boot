package com.java.crud.service;

import com.java.crud.dto.UserData;
import com.java.crud.entity.User;
import com.java.crud.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserData getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.orElse(null);
        return this.modelMapper.map(user, UserData.class);
    }

    @Override
    @Transactional
    public UserData saveUser(UserData userData) {
        User user = this.modelMapper.map(userData, User.class);
        user = userRepository.save(user);
        return this.modelMapper.map(user, UserData.class);
    }

    @Override
    @Transactional
    public UserData updateUser(Long userId, UserData userData) throws Exception {
        Optional<User> existingUserOptional = userRepository.findById(userId);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setName(userData.getName());
            existingUser.setMobile(userData.getMobile());
            existingUser.setEmail(userData.getEmail());
            User updatedUser = userRepository.save(existingUser);
            return this.modelMapper.map(updatedUser, UserData.class);
        } else {
            throw new Exception("User not found with id " + userId);
        }
    }

    @Override
    @Transactional
    public void deleteUser(Long userId) throws Exception {
        Optional<User> existingUserOptional = userRepository.findById(userId);
        if (existingUserOptional.isPresent()) {
            userRepository.deleteById(userId);
        } else {
            throw new Exception("User not found with id " + userId);
        }
    }

}
