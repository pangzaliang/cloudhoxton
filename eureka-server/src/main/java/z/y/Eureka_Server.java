package z.y;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 开启注册中心
public class Eureka_Server {
    public static void main(String[] args) {
        SpringApplication.run(Eureka_Server.class, args);
    }
}