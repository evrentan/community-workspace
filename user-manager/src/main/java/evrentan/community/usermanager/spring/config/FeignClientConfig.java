package evrentan.community.usermanager.spring.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "evrentan.community.usermanager")
public class FeignClientConfig {
}
