package example.Model;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class LoginService {
    public User logIn(String email , String pw) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection("Users").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        HashMap<String, User> userHashMap = new HashMap<>();
        for (QueryDocumentSnapshot document : documents) {
            userHashMap.put(document.toObject(User.class).getEmail(), document.toObject(User.class));
        }
        if (userHashMap.containsKey(email)) {
            System.out.println("User found!");
            User known_user;
            known_user = userHashMap.get(email); //fetching user from hashmap
            if (known_user.getPassword().equals(pw)) {   //return User if pw and username match
                return known_user;
            }
        }
        return null; //user not found return false;
    }
}