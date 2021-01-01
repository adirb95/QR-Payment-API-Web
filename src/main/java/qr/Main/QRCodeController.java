package qr.Main;

import com.google.zxing.WriterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class QRCodeController {

    private static final String QR_CODE_IMAGE_PATH = "C:\\Users\\Sharon\\Desktop\\QRCode.png";


    @GetMapping(value = "/genrateAndDownloadQRCode/{codeText}/{width}/{height}")
    public void download(
            @PathVariable("codeText") String codeText,
            @PathVariable("width") Integer width,
            @PathVariable("height") Integer height)
            throws Exception {
        QRCodeGenerator.generateQRCodeImage(codeText, width, height, QR_CODE_IMAGE_PATH);
    }

    @GetMapping(value = "/genrateQRCode")
    public ResponseEntity<byte[]> generateQRCode(@RequestBody CodeText codeText) throws IOException, WriterException {

            return ResponseEntity.status(HttpStatus.OK).body(QRCodeGenerator.getQRCodeImage(codeText.getCodeTextString(), 480, 480));

    }
}