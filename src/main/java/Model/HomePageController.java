package Model;

import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Controller
public class HomePageController {

    @GetMapping("/homepage")
    String home(Model model){

    model.addAttribute("name","sharon");
    return "welcomepage";
}
}
