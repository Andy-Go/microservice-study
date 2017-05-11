package eli.user;

import eli.user.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by eli.f.zhi on 3/19/2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Log log= LogFactory.getLog(UserController.class);
    @GetMapping("/{id}")
   public User findUser(@PathVariable("id") String id){
      log.info("user server find id="+id);
      User user=new User();
      user.setId(id);
      user.setAddress("Shanxin");
      user.setName("Eli来自后端");

      return user;
   }
}
