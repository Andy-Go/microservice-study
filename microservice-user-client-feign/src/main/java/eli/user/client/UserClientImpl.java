package eli.user.client;

import eli.user.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by eli.f.zhi on 3/25/2017.
 */
@Component
public class UserClientImpl implements UserClient {
    private static final Log log= LogFactory.getLog(UserClientImpl.class);
    public UserClientImpl(){}

    @Override
    public User findUser(@PathVariable("id") String id) {
        log.info("trigger defaultUser");
        User user=new User();
        user.setId(id);
        user.setAddress("Unknow");
        user.setName("Unknow");
        return user;
    }
}
