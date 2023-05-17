package evrentan.community.communitymanager.spring.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "evrentan.community.communitymanager")
public class FeignClientConfig {
}
