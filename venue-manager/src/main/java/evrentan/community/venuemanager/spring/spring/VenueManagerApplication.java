package evrentan.community.venuemanager.spring.spring;

import evrentan.community.venuemanager.spring.config.*;
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
public class VenueManagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(VenueManagerApplication.class, args);
  }

}
