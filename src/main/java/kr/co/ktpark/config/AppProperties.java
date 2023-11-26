package kr.co.ktpark.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// @ConfigurationProperties 사용을 위해선 의존성 관리 추가가 필요하다.
//    ==> application.properties 에서 사용하는 ${} 자동완성 메타정보 가능케 함
//    ==> spring-boot-configuration-processor
@Configuration
@ConfigurationProperties("app")
public class AppProperties {

    String name;
    String desc;
    String version;
    String mode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "AppProperties{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", version='" + version + '\'' +
                ", mode='" + mode + '\'' +
                '}';
    }
}
