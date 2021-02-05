package example.Controller;

import com.google.zxing.WriterException;
import example.Model.QRCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin
public class QRCodeController {

    @Autowired
    QRCodeGenerator qrCodeGenerator;

        @GetMapping(value = "/generateAndDownloadQRCode")
    public void download()
            throws Exception {
        String codeText = "sharon";
        QRCodeGenerator qrCodeGenerator = new QRCodeGenerator();
        qrCodeGenerator.generateQRCodeImage(codeText);
    }
        @PostMapping(value = "/generateQR")
        public byte[] generateQR(@RequestBody String paymentDetails) throws IOException, WriterException {
            System.out.println("QR generation initiated");
            return qrCodeGenerator.getQRCodeImage(paymentDetails);
        }

    /*@GetMapping(value = "/genrateQRCode")
    public ResponseEntity<byte[]> generateQRCode(@RequestBody CodeText codeText) throws IOException, WriterException {

            return ResponseEntity.status(HttpStatus.OK).body(QRCodeGenerator.getQRCodeImage(codeText.getCodeTextString(), 480, 480));
        }
    */
}