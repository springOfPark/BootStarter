package kr.co.ktpark.web.testSample;

import org.assertj.core.api.StringAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleTomcatControllerTest {

    // Using for webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT OR DEFINED_PORT (내장 톰캣 사용)
    @Autowired
    private TestRestTemplate testRestTemplate;

    // 컨트롤러만 테스트 하고 싶은 경우
    // SampleService 를 MockBean 으로 교체함
    // 서비스 기능이 큰 경우 가짜로 교체하여 비용을 줄여서 테스트
    @MockBean
    private SampleService mockSampleService;

    @Test
    @DisplayName("Sample Service 를 목킹하여 가짜 테스트")
    public void helloServiceTest() throws Exception {
        // 이제 SampleService 에 getName 메소드를 호출하면 'KTPARK' 으로 리턴하게 한다.
        when(mockSampleService.getName()).thenReturn("KTPARK");

        String result = testRestTemplate.getForObject("/hello", String.class);
        StringAssert stringAssert = new StringAssert(result);
        stringAssert.isEqualTo("Hello, KTPARK");
    }

    @Test
    @DisplayName("서블릿이 랜덤포트에 뜨면서 실제 웹서버가 동작하는 것처럼 테스트")
    public void hello() throws Exception {
        String result = testRestTemplate.getForObject("/hello", String.class);
        StringAssert stringAssert = new StringAssert(result);
        stringAssert.startsWith("Hello");
    }

}
