package com.yangrd.ipress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author yangrd
 * @date 2019/05/13
 */
@SpringBootApplication
@EnableJpaAuditing
public class IPressRunApplication {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:8080","https://sunxyz.gitee.io")
                        .allowedMethods("PUT", "DELETE","GET","POST")
                        .allowCredentials(false).maxAge(3600);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(IPressRunApplication.class, args);
    }

}
