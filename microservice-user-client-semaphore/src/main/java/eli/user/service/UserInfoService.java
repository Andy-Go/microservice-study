package eli.user.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import eli.user.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by eli.f.zhi on 3/25/2017.
 */
@Component
public class UserInfoService {
    private static final Log log= LogFactory.getLog(UserInfoService.class);
   @Autowired
   private RestTemplate restTemplate;

  @HystrixCommand(fallbackMethod = "defaultUser",commandProperties = {
          @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
  })
   public User findUser(String id){
       return restTemplate.getForEntity("http://user-service/user/"+id,User.class).getBody();
   }

   public User defaultUser(String id){
       log.info("trigger defaultUser");
       User user=new User();
       user.setId(id);
       user.setAddress("Unknow");
       user.setName("Unknow");
       return user;
   }
}
