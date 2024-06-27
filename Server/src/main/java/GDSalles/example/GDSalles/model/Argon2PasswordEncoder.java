package GDSalles.example.GDSalles.model;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
public class SecurityConfig {
@Bean
public class Argon2PasswordEncoder {
    return new Argon2PasswordEncoder();
}
}