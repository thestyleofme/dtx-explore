package org.abigballofmud.demo2.app.impl;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.abigballofmud.demo2.app.AccountInfoService;
import org.abigballofmud.demo2.domain.entity.AccountInfo;
import org.abigballofmud.demo2.infra.mapper.AccountInfoMapper;
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

    public AccountInfoServiceImpl(AccountInfoMapper accountInfoMapper) {
        this.accountInfoMapper = accountInfoMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String transferAccount(String accountNo, BigDecimal amount) {
        // bank2 账户余额更新
        AccountInfo accountInfo = accountInfoMapper.selectOne(new QueryWrapper<>(AccountInfo.builder().accountNo(accountNo).build()));
        accountInfo.setAccountBalance(accountInfo.getAccountBalance().add(amount));
        accountInfoMapper.updateById(accountInfo);
        // 模仿出错
        // throw new IllegalStateException();
        return "success";
    }
}
