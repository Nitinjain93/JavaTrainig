package com.example.demo2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")  // Enabling JPA Auditing
public class AuditConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl(); // Your custom AuditorAware implementation
    }
}
