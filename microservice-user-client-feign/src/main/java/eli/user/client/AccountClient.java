package eli.user.client;

import eli.user.model.Account;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by eli.f.zhi on 3/25/2017.
 */
@FeignClient(value = "account-service",fallback = AccountClientImpl.class)
public interface AccountClient {
    @RequestMapping(value="/account/{id}",method = RequestMethod.GET)
    Account findAccount(@PathVariable("id")String id);
}
