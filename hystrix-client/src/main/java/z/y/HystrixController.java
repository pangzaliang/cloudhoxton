package z.y;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class HystrixController {

    @Autowired
    private HystrixService hystrixService;

    @GetMapping("/hystrix_consumer")
    public String hystrixConsumer() {
        return hystrixService.hello();
    }
    @GetMapping("/hystrix_consumer_async")
    public String hystrixConsumerAsync() throws ExecutionException, InterruptedException {
        return hystrixService.hello(true).get();
    }

}
