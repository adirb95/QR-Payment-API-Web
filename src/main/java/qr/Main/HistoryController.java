package qr.Main;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import qr.Main.HistoryService;
import qr.Main.Payment;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @GetMapping("/history")
    List<Payment> getHistory() throws ExecutionException, InterruptedException {
        return HistoryService.getPayments();
    }

}
