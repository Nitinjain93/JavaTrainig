package com.example.demo2.config;

import org.springframework.data.domain.AuditorAware;
import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Return the username of the current logged-in user, for now returning a hardcoded value.
        // In a real application, this would fetch the user from the security context.
        return Optional.of("admin");  // Placeholder for user details, can integrate with Spring Security.
    }
}
