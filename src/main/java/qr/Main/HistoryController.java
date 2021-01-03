package qr.Main;

import com.google.common.io.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.Quota;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
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
