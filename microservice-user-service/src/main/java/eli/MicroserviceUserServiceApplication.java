package eli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by eli.f.zhi on 3/19/2017.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceUserServiceApplication {
    public static void main(String[] args) {

        SpringApplication.run(MicroserviceUserServiceApplication.class, args);
    }
}
