package eli.user.client;

import eli.user.model.Account;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by eli.f.zhi on 3/25/2017.
 */
@Component
public class AccountClientImpl implements AccountClient {
    private static final Log log = LogFactory.getLog(AccountClientImpl.class);

    @Override
    public Account findAccount(@PathVariable("id") String id) {
        log.info("trigger feign defaultAccount");
        Account account = new Account();
        account.setId(id);
        account.setFrozen(-1);
        account.setBalance(-1);
        account.setTotal(-1);
        return account;
    }
}
