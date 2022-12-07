package evrentan.community.eventmanager.spring.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(value = "evrentan.community.eventmanager")
@EnableJpaRepositories(value = "evrentan.community.eventmanager.repository")
@EntityScan(value = "evrentan.community.eventmanager.entity")
public class CommonConfig {
}
