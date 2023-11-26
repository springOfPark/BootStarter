package kr.co.ktpark;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:/applicationTest.properties")
class ApplicationTest {

    @Autowired
    Environment environment;

    @Test
    public void contextLoads() {
        String appName = environment.getProperty("app.name");
        String appDesc = environment.getProperty("app.desc");
        System.out.println(appName);
        System.out.println(appDesc);
    }

}