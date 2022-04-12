package evrentan.community.usermanager.spring.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(value = "evrentan.community.usermanager")
@EnableJpaRepositories(value = "evrentan.community.usermanager.repository")
@EntityScan(value = "evrentan.community.usermanager.entity")
public class CommonConfig {
}