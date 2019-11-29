package org.abigballofmud.demo2.api.controller;

import java.math.BigDecimal;

import org.abigballofmud.demo2.app.AccountInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * description
 * </p>
 *
 * @author isacc 2019/11/30 0:49
 * @since 1.0
 */
@RestController
@RequestMapping("/account-info")
public class AccountInfoController {

    private final AccountInfoService accountInfoService;

    public AccountInfoController(AccountInfoService accountInfoService) {
        this.accountInfoService = accountInfoService;
    }

    @GetMapping("/{accountNo}")
    public String transferAccount(@PathVariable String accountNo, BigDecimal amount) {
        return accountInfoService.transferAccount(accountNo, amount);
    }
}
