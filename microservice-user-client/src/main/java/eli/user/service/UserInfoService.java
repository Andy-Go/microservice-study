package eli.user.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import eli.user.model.Account;
import eli.user.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by eli.f.zhi on 3/25/2017.
 */
@Component
public class UserInfoService {
    private static final Logger log= LoggerFactory.getLogger(UserInfoService.class);
   @Autowired
   private RestTemplate restTemplate;

  @HystrixCommand(fallbackMethod = "defaultUser")
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
    @HystrixCommand(fallbackMethod = "defaultAccount")
   public Account findAccount(String id){
       return restTemplate.getForEntity("HTTP://account-service/account/"+id,Account.class).getBody();
   }

   public Account defaultAccount(String id){
       log.info("trigger defaultAccount");
       Account account=new Account();
       account.setId(id);
       account.setFrozen(-1);
       account.setBalance(-1);
       account.setTotal(-1);
       return account;
   }
}
