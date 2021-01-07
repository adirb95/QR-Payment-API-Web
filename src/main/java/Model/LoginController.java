package Model;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Model.LoginInfo;
import Model.LoginService;
import Model.User;

import java.util.concurrent.ExecutionException;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;
    @PostMapping("/Login")
    User getUser(@RequestBody LoginInfo loginInfo) throws ExecutionException, InterruptedException {
        System.out.println("login request Initiated");
        return loginService.logIn(loginInfo.getEmail(),loginInfo.getPassword());
    }

    @GetMapping("/hello")
    String returnHello () throws JSONException {
       User user=new User();
       user.setFirstName("adir");
       return "hello";
    }

}
