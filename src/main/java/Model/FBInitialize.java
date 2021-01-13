package Model;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Objects;

@Service
public class FBInitialize {

    @PostConstruct
    public void initialize() {
        try {
            String fileName = "src/main/java/jsonfile/qr-database-a6078-firebase-adminsdk-885ht-5dd2f2d0f1.json";
            ClassLoader classLoader = getClass().getClassLoader();
            /*File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());*/
            File file = new File(fileName);
            FileInputStream serviceAccount = new FileInputStream("BOOT-INF/classes/qr-database-a6078-firebase-adminsdk-885ht-5dd2f2d0f1.json");
            GoogleCredentials googleCred=GoogleCredentials.fromStream(serviceAccount);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(googleCred)
                    .setDatabaseUrl("https://qr-database-a6078.firebaseio.com")
                    .build();

                    FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}