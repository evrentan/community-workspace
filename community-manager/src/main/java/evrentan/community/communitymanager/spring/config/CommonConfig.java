package evrentan.community.communitymanager.spring.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(value = "evrentan.community.communitymanager")
@EnableJpaRepositories(value = "evrentan.community.communitymanager.repository")
@EntityScan(value = "evrentan.community.communitymanager.entity")
public class CommonConfig {
}