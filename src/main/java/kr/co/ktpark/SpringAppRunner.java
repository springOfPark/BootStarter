package kr.co.ktpark;

import kr.co.ktpark.config.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringAppRunner implements ApplicationRunner {

    static final Logger logger = LoggerFactory.getLogger(SpringAppRunner.class);

    @Autowired
    AppProperties appProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        logger.info("App Properties Value Object : {}", appProperties);

    }
}
