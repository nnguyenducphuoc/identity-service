package com.phuoc.identity_service.config;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AuthConfig {

    @Bean
    public PasswordEncoder providePasswordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public JWSHeader provideJWSHeader() {
        return new JWSHeader(JWSAlgorithm.HS512);
    }
}
