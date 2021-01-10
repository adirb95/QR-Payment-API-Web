package Model;

import com.google.zxing.WriterException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.io.IOException;


@SpringBootApplication()
public class QrPaymentProjectApplication {

    public static void main(String[] args) throws IOException, WriterException {
        SpringApplication.run(QrPaymentProjectApplication.class, args);

    }

}
