package example.Model;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Servi@Service
public class HistoryService {

    public static List<Payment> getPayments(User user) throws InterruptedException, ExecutionException {
        System.out.println("History requested");
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("Payments").document(user.getId());
        ApiFuture<QuerySnapshot> documentQuery = documentReference.collection(user.getId()).get();
        List<QueryDocumentSnapshot> documentSnapshots = documentQuery.get().getDocuments();
        List<Payment> paymentList = new ArrayList<>();
        for (QueryDocumentSnapshot document : documentSnapshots) {
            paymentList.add(document.toObject(Payment.class));
        }
        return paymentList;
    }
/*public String addNewPaymentToUser(User user,Payment payment){
    Firestore dbFirestore = FirestoreClient.getFirestore();
    
}*/

}
