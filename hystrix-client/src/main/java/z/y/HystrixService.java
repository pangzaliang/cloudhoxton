package z.y;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.FileNotFoundException;
import java.util.concurrent.Future;

@Service
public class HystrixService {

    @Autowired
    private RestTemplate restTemplate;


    /**
     * 同步请求
     * @return
     */
    // 通过 @HystrixCommand 注解的 fallbackMethod 属性指定服务降级的实现方法
    @HystrixCommand(fallbackMethod = "helloFallBack", commandKey = "命令名称", groupKey = "分组名称", threadPoolKey = "线程名称")
    public String hello() {
        return restTemplate.getForEntity("http://EUREKA-CLIENT/hello", String.class).getBody();
    }

    public String helloFallBack() {
        return "error";
    }


    /**
     * 异步请求
     * @param ss
     * @return
     *
     */
    @CacheResult
    // 定义降级方法 遇到某个异常不降级
    @HystrixCommand(ignoreExceptions = FileNotFoundException.class)
    public Future<String> hello (boolean ss) {
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                return restTemplate.getForEntity("http://EUREKA-CLIENT/hello", String.class).getBody();
            }
        };
    }

}
