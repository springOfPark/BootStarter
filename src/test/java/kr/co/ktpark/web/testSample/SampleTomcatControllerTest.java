package kr.co.ktpark.web.testSample;

import org.assertj.core.api.StringAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleTomcatControllerTest {

    // Using for webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("서블릿이 랜덤포트에 뜨면서 실제 웹서버가 동작하는 것처럼 테스트")
    public void hello() throws Exception {
        String result = testRestTemplate.getForObject("/hello", String.class);
        StringAssert stringAssert = new StringAssert(result);
        stringAssert.startsWith("Hello");
    }

}
