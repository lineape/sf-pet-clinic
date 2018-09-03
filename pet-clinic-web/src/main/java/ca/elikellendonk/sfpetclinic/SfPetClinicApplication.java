package ca.elikellendonk.sfpetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class SfPetClinicApplication {

  public static void main(String[] args) {
    SpringApplication.run(SfPetClinicApplication.class, args);
  }

  @Configuration
  @Profile("local")
  @ComponentScan(lazyInit = true)
  static class LocalConfig {}
}
