package evrentan.community.eventmanager.spring.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "evrentan.community.eventmanager")
public class FeignClientConfig {
}
