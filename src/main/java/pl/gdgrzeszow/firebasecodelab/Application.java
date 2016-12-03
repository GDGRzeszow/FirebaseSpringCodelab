package pl.gdgrzeszow.firebasecodelab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import pl.gdgrzeszow.firebasecodelab.service.FirebaseService;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) throws Exception {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        context.getBean(FirebaseService.class).startFirebaseListener();
    }
}

