package eli.user.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import config.UserClientConfig;
import eli.user.model.User;

/**
 * Created by eli.f.zhi on 3/25/2017.
 */
@FeignClient(value = "user-service",
        configuration = UserClientConfig.class,
        fallback=UserClientImpl.class
        /*fallbackFactory = UserClientFallbackFactory.class*/)
public interface UserClient {
    @RequestMapping(value="/user/{id}",method = RequestMethod.GET)
    User findUser(@PathVariable("id")String id);
}
