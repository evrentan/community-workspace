package evrentan.community.eventmanager.spring.spring;

import evrentan.community.eventmanager.spring.config.CommonConfig;
import evrentan.community.eventmanager.spring.config.SwaggerConfig;
import evrentan.community.eventmanager.spring.config.TransactionManagementConfig;
import evrentan.community.eventmanager.spring.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


//@SpringBootApplication(scanBasePackages="evrentan.community.eventmanager.spring")
@SpringBootApplication
@Import(value = {CommonConfig.class,
    SwaggerConfig.class,
    TransactionManagementConfig.class,
    WebConfig.class})

public class EventManagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(EventManagerApplication.class, args);
  }

}
