package org.abigballofmud.demo1.api.dto;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * <p>
 * description
 * </p>
 *
 * @author isacc 2019/11/30 0:51
 * @since 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@TableName("account_info")
public class AccountInfoDTO {

    @TableId
    private Long id;

    private String accountName;

    private String accountNo;

    private String accountPassword;

    private BigDecimal accountBalance;

}
