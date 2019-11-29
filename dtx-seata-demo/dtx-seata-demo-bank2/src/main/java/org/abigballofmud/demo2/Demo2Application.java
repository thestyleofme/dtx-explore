package org.abigballofmud.demo2;

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
 * @author isacc 2019/11/29 17:32
 * @since 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class Demo2Application {

    public static void main(String[] args) {
        try {
            SpringApplication.run(Demo2Application.class,args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
