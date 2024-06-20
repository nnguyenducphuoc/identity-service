package com.phuoc.identity_service.controller;

import com.phuoc.identity_service.dto.request.ApiResponse;
import com.phuoc.identity_service.dto.request.UserCreationRequest;
import com.phuoc.identity_service.dto.request.UserUpdateRequest;
import com.phuoc.identity_service.entity.User;
import com.phuoc.identity_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    ApiResponse<User> createUser(@Valid @RequestBody UserCreationRequest user) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(user));

        return apiResponse;
    }

    @GetMapping
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") String userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@RequestBody UserUpdateRequest user, @PathVariable("userId") String userId) {
        return userService.updateUser(user, userId);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
        return "User deleted";
    }
}
