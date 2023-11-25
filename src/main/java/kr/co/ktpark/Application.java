package kr.co.ktpark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

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
        Arrays.stream(args).forEach(System.out::println);
        SpringApplication.run(Application.class, args);
    }

}
