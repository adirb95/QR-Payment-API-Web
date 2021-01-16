package example.Model;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


public class QRCodeGenerator {

    JsonIO jsonIO;

    public void generateQRCodeImage(String text)
            throws WriterException, IOException {

        Path newpath= Paths.get("src/main/resources/static/images/newpicture.png");
        MerchantNewPayment merchantNewPayment =new MerchantNewPayment();
        merchantNewPayment.setMerchantName("mega");
        merchantNewPayment.setTransactionAmount(73.50);
        jsonIO=new JsonIO();
        String objectjsonstring=jsonIO.Object_to_JsonString(merchantNewPayment);
        System.out.println(objectjsonstring);
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(objectjsonstring, BarcodeFormat.QR_CODE, 400, 400);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG",newpath);
    }

    public static byte[] getQRCodeImage(String text) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE,400, 400);
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        return pngOutputStream.toByteArray();
    }

}