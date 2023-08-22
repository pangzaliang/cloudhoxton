package z.y;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@SpringBootApplication
@EnableDiscoveryClient //开启EurekaClient
public class Eureka_Client {

    @Autowired
    private DiscoveryClient client;

    public static void main(String[] args) {
        SpringApplication.run(Eureka_Client.class, args);
    }

    @GetMapping("/hello")
    public void hello() {
        // 所有已知的服务ID
        List<String> services = client.getServices();
        for (String service : services) {
            // 服务实例列表
            List<ServiceInstance> instances = client.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println("host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
            }
        }
    }

}