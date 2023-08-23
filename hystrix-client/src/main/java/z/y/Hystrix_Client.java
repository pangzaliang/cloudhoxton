package z.y;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;


//@SpringBootApplication
//@EnableDiscoveryClient // EurekaClient
//@EnableCircuitBreaker // 开启断路器

// 与上面三个注解相同
@SpringCloudApplication
public class Hystrix_Client {
    public static void main(String[] args) {
        SpringApplication.run(Hystrix_Client.class, args);
    }
}