package com.htht.huoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HuoyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuoyApplication.class, args);
    }

    @ResponseBody
    @RequestMapping("/generator")
    public String generator(){
        return "generator";
    }
}
