package esgi.hackathon.bootstrap;

import esgi.hackathon.bootstrap.config.ApplicationConfiguration;
import extia.hackathon.postgres.MariaDbPersistenceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({ApplicationConfiguration.class, MariaDbPersistenceConfiguration.class})
@SpringBootApplication(scanBasePackages = "esgi.hackathon")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
