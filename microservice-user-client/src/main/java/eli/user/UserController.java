package eli.user;

import eli.user.model.Account;
import eli.user.model.User;
import eli.user.model.UserInfo;
import eli.user.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by eli.f.zhi on 3/19/2017.
 */
@RestController
@RequestMapping("/client/user")
public class UserController {
    private static final Logger log= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserInfoService userInfoService;
    @GetMapping("/{id}")
   public UserInfo findUser(@PathVariable("id") String id){
      log.info("user client find id={}",id);

      User user=userInfoService.findUser(id);
      Account account=userInfoService.findAccount(id);

      UserInfo userInfo = new UserInfo();
      userInfo.setAccount(account);
      userInfo.setUser(user);
      return userInfo;
   }

}
