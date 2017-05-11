package eli.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eli.user.client.AccountClient;
import eli.user.client.UserClient;
import eli.user.model.Account;
import eli.user.model.User;
import eli.user.model.UserInfo;

/**
 * Created by eli.f.zhi on 3/19/2017.
 */
@RestController
@RequestMapping("/feignclient/user")
public class UserController {
    private static final Logger log= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserClient userClient;
    @Autowired
    private AccountClient accountClient;
    @GetMapping("/{id}")
   public UserInfo findUser(@PathVariable("id") int id){
      log.info("user client find id={}",id);
      User user=userClient.findUser(""+id);
      Account account=accountClient.findAccount(""+id);

      UserInfo userInfo = new UserInfo();
      userInfo.setUser(user);
      userInfo.setAccount(account);
      return userInfo;
   }

    @GetMapping("/account/{id}")
    public Account findAccount(@PathVariable("id") int id){
        log.info("user client find account id={}",id);
        Account account=accountClient.findAccount(""+id);

        return account;
    }

    @GetMapping("/baseuser/{id}")
    public User findBaseUser(@PathVariable("id") int id){
        log.info("user client find baseuser id={}",id);
        User user=userClient.findUser(""+id);

        return user;
    }
}
