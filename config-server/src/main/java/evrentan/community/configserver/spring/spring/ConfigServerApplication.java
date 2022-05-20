package evrentan.community.configserver.spring.spring;

import evrentan.community.configserver.spring.config.ConfigServerConfig;
import evrentan.community.configserver.spring.config.ServiceDiscoveryClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = {ConfigServerConfig.class
    , ServiceDiscoveryClientConfig.class})
public class ConfigServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConfigServerApplication.class, args);
  }

}
