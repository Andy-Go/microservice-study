package eli;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import feign.Feign;
import feign.Target;
import feign.hystrix.HystrixFeign;
import feign.hystrix.SetterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.lang.reflect.Method;

/**
 * Created by eli.f.zhi on 3/26/2017.
 */
@Configuration
public class FeignConfig {
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {

        SetterFactory setterFactory = new feign.hystrix.SetterFactory.Default();
        SetterFactory sf=new SetterFactory(){
            @Override
            public HystrixCommand.Setter create(Target<?> target, Method method) {
                HystrixCommandProperties.Setter setter=HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE);

                String groupKey = target.name();
                String commandKey = Feign.configKey(target.type(), method);

                return HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupKey)).
                        andCommandKey(com.netflix.hystrix.HystrixCommandKey.Factory.asKey(commandKey)).
                        andCommandPropertiesDefaults(setter);

            }
        };
        return HystrixFeign.builder().setterFactory(sf);
    }
}
