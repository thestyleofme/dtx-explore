package org.abigballofmud.demo1.infra.feign.fallback;

import java.math.BigDecimal;

import lombok.extern.slf4j.Slf4j;
import org.abigballofmud.demo1.infra.feign.AccountInfoFeign;
import org.springframework.stereotype.Component;

/**
 * <p>
 * description
 * </p>
 *
 * @author isacc 2019/11/29 23:46
 * @since 1.0
 */
@Component
@Slf4j
public class AccountInfoFeignFallback implements AccountInfoFeign {

    @Override
    public String transferAccount(String accountNo, BigDecimal amount) {
        log.error("transferAccount fallback, accountNo: {}", accountNo);
        return "fallback";
    }
}
