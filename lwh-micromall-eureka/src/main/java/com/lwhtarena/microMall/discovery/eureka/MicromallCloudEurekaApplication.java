package com.lwhtarena.microMall.discovery.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program lwh-microMall
 * @description:
 * @author: liwh
 * @create: 2019/03/10 22:17
 **/

@EnableEurekaServer
@SpringBootApplication
public class MicromallCloudEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicromallCloudEurekaApplication.class,args);
    }
}
