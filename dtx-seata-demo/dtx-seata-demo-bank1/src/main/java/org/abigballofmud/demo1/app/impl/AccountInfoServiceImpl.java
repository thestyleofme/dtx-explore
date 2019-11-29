package org.abigballofmud.demo1.app.impl;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.seata.spring.annotation.GlobalTransactional;
import org.abigballofmud.demo1.app.AccountInfoService;
import org.abigballofmud.demo1.entity.AccountInfo;
import org.abigballofmud.demo1.infra.feign.AccountInfoFeign;
import org.abigballofmud.demo1.infra.mapper.AccountInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * description
 * </p>
 *
 * @author isacc 2019/11/30 0:53
 * @since 1.0
 */
@Service
public class AccountInfoServiceImpl implements AccountInfoService {

    private final AccountInfoMapper accountInfoMapper;
    private final AccountInfoFeign accountInfoFeign;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public AccountInfoServiceImpl(AccountInfoMapper accountInfoMapper,
                                  AccountInfoFeign accountInfoFeign) {
        this.accountInfoMapper = accountInfoMapper;
        this.accountInfoFeign = accountInfoFeign;
    }

    @Override
    @GlobalTransactional
    @Transactional(rollbackFor = Exception.class)
    public String transferAccount(String accountNo, BigDecimal amount) {
        // bank1 账户余额减
        AccountInfo accountInfo = accountInfoMapper.selectOne(new QueryWrapper<>(AccountInfo.builder().accountNo(accountNo).build()));
        accountInfo.setAccountBalance(accountInfo.getAccountBalance().subtract(amount));
        accountInfoMapper.updateById(accountInfo);
        // bank2 账户余额加
        accountInfoFeign.transferAccount(accountNo, amount);
        throw new IllegalStateException();
    }

}
