package qr.Main;

import com.google.api.core.ApiFuture;
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

    public static List<Payment> getPayments() throws InterruptedException, ExecutionException {
        System.out.println("History requested");
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection("Payments").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<Payment> paymentList = new ArrayList<>();
        for (QueryDocumentSnapshot document : documents) {
            paymentList.add(document.toObject(Payment.class));
        }
        return paymentList;
    }
}
