package kr.co.ktpark.web.cors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping
public class CorsTestController {

    @CrossOrigin(origins = "http://localhost:8050") // 해당 클라이언트에서 요청할 때 CORS 허용
    // CORS 전역 설정 : implements WebMvcConfigurer
    @RequestMapping("/cors/test")
    @ResponseBody
    public String testCors() {
        return "HELLO";
    }

}
