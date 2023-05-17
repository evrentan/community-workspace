package evrentan.community.venuemanager.spring.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "evrentan.community.venuemanager")
public class FeignClientConfig {
}
