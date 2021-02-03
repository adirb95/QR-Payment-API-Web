package example.Controller;

import example.Model.HistoryService;
import example.Model.MerchantUser;
import example.Model.Payment;
import example.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @PostMapping("/history")
    List<Payment>  getHistory(@RequestBody User user) throws ExecutionException, InterruptedException {
        return HistoryService.getPayments(user);
    }

    @PostMapping("/merchantHistory")
    List<Payment> getMerchantHistory (@RequestBody MerchantUser merchant) throws ExecutionException, InterruptedException {
        return HistoryService.getMerchantPayments(merchant);
    }

    @GetMapping("/welcome")
    String welcomepage(Model model){
        model.addAttribute("welcomepage","hello");
        return "welcome";
   /* @PostMapping("/newpayment")*/

    }


 /*   QRCodeGenerator qrCodeGenerator;
    @GetMapping("/hello")
    void Generateqr() throws IOException, WriterException {
        MerchantNewPayment merchantNewPayment=new MerchantNewPayment();
        merchantNewPayment.setMerchantName("mega");

        qrCodeGenerator=new QRCodeGenerator();
        qrCodeGenerator.generateQRCodeImage(merchantNewPayment.toString(),qrCodeGenerator.getSource());
    }*/


}
