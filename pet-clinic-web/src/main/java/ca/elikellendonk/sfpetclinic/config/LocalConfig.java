package ca.elikellendonk.sfpetclinic.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
@ComponentScan(lazyInit = true)
public class LocalConfig {}
