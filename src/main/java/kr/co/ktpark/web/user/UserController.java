package kr.co.ktpark.web.user;


import kr.co.ktpark.web.user.vo.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/user/hello")
    public String hello() {
        return "HELLO";
    }

    // @ResponseBody => @RestController 에서는 생략 가능
    // @ReqponseBody
    //    ==> HttpMessageConverter 가 변환해줌
    @PostMapping("/user/create")
    public User create(@RequestBody User user) {
        return user;
    }
}
