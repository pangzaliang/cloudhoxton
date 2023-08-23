package z.y;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class Hystrix_Dashborad {
    public static void main(String[] args) {
        SpringApplication.run(Hystrix_Dashborad.class, args);
    }
}