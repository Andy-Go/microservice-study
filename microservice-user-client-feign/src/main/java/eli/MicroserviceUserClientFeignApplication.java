package eli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by eli.f.zhi on 3/19/2017.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class MicroserviceUserClientFeignApplication {

    public static void main(String[] args) {

        SpringApplication.run(MicroserviceUserClientFeignApplication.class, args);
    }
}
