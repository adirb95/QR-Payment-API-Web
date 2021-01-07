package Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import Model.HistoryService;
import Model.Payment;

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
    @GetMapping("/welcome")
    String welcomepage(Model model){
        model.addAttribute("welcomepage","hello");
        return "welcome";
    }

}
