package qr.Main;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;

import org.apache.commons.logging.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    User returnHello () throws JSONException {
       User user=new User();
       user.setFirstName("adir");
       return user;
    }

}
