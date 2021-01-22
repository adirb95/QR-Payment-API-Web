package example.Model;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

@Service
public class QRCodeGenerator {

    public void generateQRCodeImage(String paymentDetails)
            throws WriterException, IOException {
        Path newpath = Paths.get("src/main/resources/static/images/newpicture.png");
        System.out.println(paymentDetails);
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(paymentDetails, BarcodeFormat.QR_CODE, 400, 400);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG",newpath);
    }

    public static byte[] getQRCodeImage(String paymentDetails) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(paymentDetails, BarcodeFormat.QR_CODE,400, 400);
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        return pngOutputStream.toByteArray();
    }

}