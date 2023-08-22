package z.y;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class Ribbon_Consumer {

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Ribbon_Consumer.class, args);
    }

    @GetMapping("/ribbon-consumer")
    public String helloConsumer() {
        // 直接访问服务名称即可
        return restTemplate.getForEntity("http://EUREKA-CLIENT/hello", String.class).getBody();
    }
}