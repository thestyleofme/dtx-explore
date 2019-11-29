package org.abigballofmud.dtx.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p>
 * description
 * </p>
 *
 * @author isacc 2019/11/29 16:57
 * @since 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class RegisterApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(RegisterApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
