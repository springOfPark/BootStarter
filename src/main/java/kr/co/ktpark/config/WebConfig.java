package kr.co.ktpark.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 스프링 부트가 제공 유지하면서 원하는 핸들러만 추가
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/m/**")
                .addResourceLocations("classpath:/m/") // 주의 : 끝 문자열 '/' 여야 함
                .setCachePeriod(20);
    }

    // CORS 전역 설정
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 컨트롤러 설정 (Path 기준 설정)
                .allowedOrigins("http://localhost:8552"); // 특정 오리진 설정
    }
}
