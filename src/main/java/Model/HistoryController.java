package Model;

import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import Model.HistoryService;
import Model.Payment;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @PostMapping("/history")
    List<Payment>  getHistory(@RequestBody User user) throws ExecutionException, InterruptedException {
        return HistoryService.getPayments(user);
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
