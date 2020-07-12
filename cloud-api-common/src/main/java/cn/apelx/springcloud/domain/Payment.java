package cn.apelx.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 支付 实体
 *
 * @author lx
 * @since 2020/4/30 9:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    /**
     * 支付ID
     */
    private Long payId;
    /**
     * 支付流水号
     */
    private String paySerialNumber;
}
