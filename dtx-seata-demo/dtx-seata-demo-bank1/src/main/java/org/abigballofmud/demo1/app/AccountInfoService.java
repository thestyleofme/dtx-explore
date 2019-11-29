package org.abigballofmud.demo1.app;

import java.math.BigDecimal;

/**
 * <p>
 * description
 * </p>
 *
 * @author isacc 2019/11/30 0:51
 * @since 1.0
 */
public interface AccountInfoService {

    /**
     * 银行转账
     *
     * @param accountNo 转账账户
     * @param amount    转账金额
     * @return String
     * @author isacc 2019/11/30 0:52
     */
    String transferAccount(String accountNo, BigDecimal amount);
}
