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
    public static void main(String[] args) throws Exception {

        SpringApplication.run(Application.class, args);

    }

    // 다른 프로젝트의 해당 클래스에
    // @ConditionalOnMissingBean 해당 빈이 등록되어있지 않은 경우에만 빈에 등록한다.
    // 어노테이션이 붙어있기 때문에 여기서 등록한 Bean이 등록된다.
    /*
    @Bean
    public Holoman holoman() {
        Holoman holoman = new Holoman();
        holoman.setName("박연귀");
        holoman.setHowLong(1);
        holoman.setNowFeel("자는중입니다.");
        return holoman;
    }
     */

}
