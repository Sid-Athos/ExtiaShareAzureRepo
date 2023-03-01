package esgi.hackathon.bootstrap;

import esgi.hackathon.bootstrap.config.ApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({ApplicationConfiguration.class})
@SpringBootApplication(scanBasePackages = "esgi.hackathon")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
