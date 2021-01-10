package qr.Main;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import qr.Main.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class HistoryService {

    public static List<Payment> getPayments(User user) throws InterruptedException, ExecutionException {
        System.out.println("History requested");
        Firestore dbFirestore = FirestoreClient.getFirestore();
        //ApiFuture<QuerySnapshot> future = dbFirestore.collection("Payments").get();
        DocumentReference documentReference = dbFirestore.collection("Payments").document("Adir");
        ApiFuture<QuerySnapshot> test = documentReference.collection("123456789").get();
        List<QueryDocumentSnapshot> documentSnapshots = test.get().getDocuments();
        //List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<Payment> paymentList = new ArrayList<>();
        for (QueryDocumentSnapshot document : documentSnapshots) {
            paymentList.add(document.toObject(Payment.class));
        }
        return paymentList;
    }
}
