package evrentan.community.communitymanager.spring.spring;

import evrentan.community.communitymanager.spring.config.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = {CommonConfig.class,
    WebConfig.class,
    TransactionManagementConfig.class,
    SwaggerConfig.class})
public class CommunityManagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(CommunityManagerApplication.class, args);
  }

}
