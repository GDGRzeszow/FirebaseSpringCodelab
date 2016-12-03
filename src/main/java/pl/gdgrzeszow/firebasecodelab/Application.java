package pl.gdgrzeszow.firebasecodelab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) throws Exception {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

         /*
            TODO: Initialize firebase service
         */
    }
}

