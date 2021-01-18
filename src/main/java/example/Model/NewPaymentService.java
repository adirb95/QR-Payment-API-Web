package example.Model;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class NewPaymentService {
    public String addNewPayement(User user, MerchantUser merchantUser, Payment payment) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReferencePayments = dbFirestore.collection("Payments").document(user.getId());
        DocumentReference documentReferenceUsers = dbFirestore.collection("Users").document(user.getId());

        /*ApiFuture<QuerySnapshot> documentQuery = documentReference.collection(user.getId()).get();*/
    /*    List<QueryDocumentSnapshot> documentSnapshots = documentQuery.get().getDocuments();
        List<Payment> paymentList = new ArrayList<>();
        for (QueryDocumentSnapshot document : documentSnapshots) {
            paymentList.add(document.toObject(Payment.class));
        }
    }*/
    return null;
    }
}