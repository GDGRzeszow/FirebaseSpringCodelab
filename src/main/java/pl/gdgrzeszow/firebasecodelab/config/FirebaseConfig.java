package pl.gdgrzeszow.firebasecodelab.config;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @Value("${firebase.path}")
    private String chatPath;

    @Value(value = "classpath:google-services.json")
    private Resource gservicesConfig;

    @Value("${firebase.database-url}")
    private String databaseUrl;

    @Bean
    public FirebaseApp provideFirebaseOptions() throws IOException {

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setServiceAccount(gservicesConfig.getInputStream())
                .setDatabaseUrl(databaseUrl)
                .build();

        return FirebaseApp.initializeApp(options);
    }

    @Bean
    @Qualifier("main")
    public DatabaseReference provideDatabaseReference(FirebaseApp firebaseApp) {
        FirebaseDatabase
                .getInstance(firebaseApp)
                .setPersistenceEnabled(false);
        return FirebaseDatabase
                .getInstance(firebaseApp)
                .getReference();
    }

}

