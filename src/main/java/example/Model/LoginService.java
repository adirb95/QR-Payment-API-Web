package example.Model;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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
        if (userHashMap.containsKey(email.toLowerCase(Locale.ROOT))) {
            System.out.println("User found! ");
            User known_user;
            known_user = userHashMap.get(email); //fetching user from hashmap
            if (known_user.getPassword().equals(pw)) {   //return User if pw and username match
                return known_user;
            }
        }
        return null; //user not found return false;
    }

    public MerchantUser merchantLogIn(String email , String pw) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection("Merchants").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        HashMap<String, MerchantUser> merchantHashMap = new HashMap<>();
        for (QueryDocumentSnapshot document : documents) {
            merchantHashMap.put(document.toObject(MerchantUser.class).getEmail(), document.toObject(MerchantUser.class));
        }
        if (merchantHashMap.containsKey(email.toLowerCase(Locale.ROOT))) {
            System.out.println("Merchant found!");
            MerchantUser known_merchant;
            known_merchant = merchantHashMap.get(email); //fetching user from hashmap
            if (known_merchant.getPassword().equals(pw)) {   //return User if pw and username match
                return known_merchant;
            }
        }
        return null; //user not found return false;
    }
}