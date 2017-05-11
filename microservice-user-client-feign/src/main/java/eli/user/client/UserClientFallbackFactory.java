package eli.user.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import eli.user.model.User;
import feign.hystrix.FallbackFactory;

/**
 * Created by eli.f.zhi on 3/26/2017.
 */
@Component
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {
    private static final Logger log= LoggerFactory.getLogger(UserClientFallbackFactory.class);
    @Override
    public UserClient create(Throwable throwable) {

        if(throwable!=null)
          log.error(">>>>>>>>>>>>>>error is {}",throwable.getMessage());
        else
            log.error(">>>>>>>>>>>>>error is unkown");
        return new UserClientWithFallbackFactory() {
            @Override
            public User findUser(@PathVariable("id") String id) {
                log.info("trigger defaultUserFactory");

                User user=new User();
                user.setId(id);
                user.setAddress("Unknow");
                user.setName("Unknow");
                return user;
            }
        };
    }
}
