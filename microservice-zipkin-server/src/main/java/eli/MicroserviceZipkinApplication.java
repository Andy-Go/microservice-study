package eli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * Created by eli.f.zhi on 3/19/2017.
 */
@SpringBootApplication
@EnableZipkinServer
public class MicroserviceZipkinApplication {
    public static void main(String[] args) {

        SpringApplication.run(MicroserviceZipkinApplication.class, args);
    }
}
