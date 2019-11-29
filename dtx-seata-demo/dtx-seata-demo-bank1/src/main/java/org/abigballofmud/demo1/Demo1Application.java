package org.abigballofmud.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>
 * description
 * </p>
 *
 * @author isacc 2019/11/29 17:35
 * @since 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class Demo1Application {
    
    public static void main(String[] args) {
        try {
            SpringApplication.run(Demo1Application.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
