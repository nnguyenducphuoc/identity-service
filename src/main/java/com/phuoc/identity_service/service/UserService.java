package com.phuoc.identity_service.service;

import com.phuoc.identity_service.dto.request.UserCreationRequest;
import com.phuoc.identity_service.dto.request.UserUpdateRequest;
import com.phuoc.identity_service.entity.User;
import com.phuoc.identity_service.exception.AppException;
import com.phuoc.identity_service.exception.ErrorCode;
import com.phuoc.identity_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserCreationRequest request) {
        User user = new User();

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(UserUpdateRequest user, String userId) {
        User userToUpdate = getUser(userId);
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setDob(user.getDob());
        return userRepository.save(userToUpdate);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
