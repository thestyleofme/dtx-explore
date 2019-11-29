package org.abigballofmud.demo1.infra.feign;

import java.math.BigDecimal;

import org.abigballofmud.demo1.infra.feign.fallback.AccountInfoFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * description
 * </p>
 *
 * @author isacc 2019/11/29 23:45
 * @since 1.0
 */
@FeignClient(
        value = "dtx-seata-demo-bank2",
        fallback = AccountInfoFeignFallback.class
)
public interface AccountInfoFeign {

    /**
     * 银行转账
     *
     * @param accountNo 转账账户
     * @param amount    转账金额
     * @author isacc 2019/11/30 0:52
     */
    @GetMapping("/account-info/{accountNo}")
    String transferAccount(@PathVariable("accountNo") String accountNo,
                         @RequestParam("amount") BigDecimal amount);
}
