package evrentan.community.eventmanager.spring.spring;

import evrentan.community.eventmanager.spring.config.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = {CommonConfig.class,
    ServiceDiscoveryClientConfig.class,
    SwaggerConfig.class,
    TransactionManagementConfig.class,
    WebConfig.class})
public class EventManagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(EventManagerApplication.class, args);
  }

}