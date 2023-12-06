package kr.co.ktpark.web.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionTestController {

    @RequestMapping("expTest")
    public String expTest() {
        throw new CustomException();
    }

    // 이 컨트롤러에서 CustomException 이 발생했을 때 아래 익셉션 처리를 탄다.
    @ExceptionHandler(CustomException.class)
    public @ResponseBody CustomErrorResult sampleError(CustomException e) {

        CustomErrorResult customErrorResult = new CustomErrorResult();

        customErrorResult.setErrorCode("ERR0R01");
        customErrorResult.setMessage("기본 오류가 발생하였습니다.");

        return customErrorResult;
    }

}
