package com.htht.huoy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan("com.htht.huoy.module")
public class HuoyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuoyApplication.class, args);
    }

}
