package kr.co.ktpark.web.formatter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FormatterTestController {

    @GetMapping("/formatter/{person}")
    @ResponseBody
    public String test(@PathVariable Person person) {
        return person.getName();
    }

    @GetMapping("/formatter/paramTest")
    @ResponseBody
    public String hi(@RequestParam("id") Person person) {
        return person.getId();
    }

}
