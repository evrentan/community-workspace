package evrentan.community.usermanager.spring.spring;

import evrentan.community.usermanager.spring.config.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(
        value = {
                CommonConfig.class,
                SwaggerConfig.class,
                TransactionManagementConfig.class,
                WebConfig.class,
                FeignClientConfig.class
        })
public class UserManagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserManagerApplication.class, args);
  }

}
