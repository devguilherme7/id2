package org.prosallo.core.infrastructure.configuration;

import org.prosallo.core.infrastructure.security.DefaultAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaAuditing
@EnableTransactionManagement
public class JpaConfiguration {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new DefaultAuditorAware();
    }
}
