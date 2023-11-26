package kr.co.ktpark;

import kr.co.ktpark.config.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringAppRunner implements ApplicationRunner {

    @Autowired
    AppProperties appProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println(appProperties);

    }
}
