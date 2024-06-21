package com.phuoc.identity_service.service;

import com.phuoc.identity_service.dto.request.AuthenticationRequest;
import com.phuoc.identity_service.exception.AppException;
import com.phuoc.identity_service.exception.ErrorCode;
import com.phuoc.identity_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public boolean authenticate(AuthenticationRequest request) {
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        return passwordEncoder.matches(request.getPassword(), user.getPassword());
    }
}
