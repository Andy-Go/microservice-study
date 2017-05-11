package eli.user;

import eli.user.model.Account;
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
@RequestMapping("/account")
public class AccountController {
    private static final Log log= LogFactory.getLog(AccountController.class);
    @GetMapping("/{id}")
   public Account findAccount(@PathVariable("id") String id){
      log.info("account server find id="+id);

      Account account=new Account();
      account.setBalance(1000);
      account.setFrozen(500);
      account.setTotal(1500);
      account.setId(id);

      return account;
   }
}
