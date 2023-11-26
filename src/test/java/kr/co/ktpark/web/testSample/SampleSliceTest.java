package kr.co.ktpark.web.testSample;

// 레이어별로 테스트 하고 싶은경우 Slice Test 사용 [테스트 최적화 가능]
// Ex) JSON, WebMvcTest (컨트롤러 하나만 테스트)

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

@WebMvcTest(SampleController.class)
public class SampleSliceTest {

    @MockBean
    SampleService mockSampleService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {

        when(mockSampleService.getName()).thenReturn("Returns");
        // ..

    }


}
