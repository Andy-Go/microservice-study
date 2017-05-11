package eli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Created by eli.f.zhi on 3/19/2017.
 */
@SpringBootApplication
@EnableTurbine
public class MicroserviceTurbineApplication {
    public static void main(String[] args) {

        SpringApplication.run(MicroserviceTurbineApplication.class, args);
    }
}
