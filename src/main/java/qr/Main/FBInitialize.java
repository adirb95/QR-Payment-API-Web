package qr.Main;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;

@Service
public class FBInitialize {

    @PostConstruct
    public void initialize() {
        try {
            String fileName = "qr-database-a6078-firebase-adminsdk-885ht-5dd2f2d0f1.json";
            ClassLoader classLoader = getClass().getClassLoader();

            File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
            FileInputStream serviceAccount = new FileInputStream(file);
                    //new FileInputStream("qr-database-a6078-firebase-adminsdk-885ht-5dd2f2d0f1.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://qr-database-a6078.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}