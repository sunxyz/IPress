package com.yangrd.ipress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author yangrd
 * @date 2019/05/13
 */
@SpringBootApplication
@EnableJpaAuditing
public class IPressRunApplication {

    public static void main(String[] args) {
        SpringApplication.run(IPressRunApplication.class, args);
    }

}
