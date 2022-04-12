package evrentan.community.venuemanager.spring.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(value = "evrentan.community.venuemanager")
@EnableJpaRepositories(value = "evrentan.community.venuemanager.repository")
@EntityScan(value = "evrentan.community.venuemanager.entity")
public class CommonConfig {
}