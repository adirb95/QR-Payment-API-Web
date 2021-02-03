package example.Controller;

import example.Model.LoginInfo;
import example.Model.LoginService;
import example.Model.MerchantUser;
import example.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;
    @PostMapping("/Login")
    User getUser(@RequestBody LoginInfo loginInfo) throws ExecutionException, InterruptedException {
        System.out.println("login request Initiated");
        return loginService.logIn(loginInfo.getEmail(),loginInfo.getPassword());
    }

    @PostMapping("/merchantLogin")
    MerchantUser getMerchant(@RequestBody LoginInfo loginInfo) throws ExecutionException, InterruptedException {
        System.out.println("login request Initiated");
        return loginService.merchantLogIn(loginInfo.getEmail(), loginInfo.getPassword());
    }
}
