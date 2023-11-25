package kr.co.ktpark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootConfiguration // 그냥 @Configuration 과 동일 (자신을 빈으로 등록)
// @ComponentScan // 첫번째로 Bean 등록
// @EnableAutoConfiguration // @ComponentScan Bean 등록 후 두번째로 다시 조회하여 Bean 등록 (이 단계가 없어도 됨)
@SpringBootApplication
public class Application {

    /*
    최초 설정 후, 메이븐 > package > jar 파일 생성 후 java -jar 생성된JAR파일.jar 하면
    패키징된 SpringBoot 가 내장된 톰캣으로 실행된다.
      --> 어떻게 실행되는 것인가?
        --> @EnableAutoConfiguration
        --> SpringApplication.run(Application.class, args);
     */
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(Application.class);
        // springApplication.setWebApplicationType(WebApplicationType.NONE); // AutoConfiguration 없이 WebApplication 으로 시작되지 않도록 설정
        springApplication.run(args);
        // SpringApplication.run(Application.class, args);
    }

}
