package cn.apelx.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 库存实体类
 *
 * @author lx
 * @since 2020/7/10 22:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage implements Serializable {
    /**
     * 主键
     */
    private Long id;
    /**
     * 产品Id
     */
    private Long productId;
    /**
     * 总库存
     */
    private Integer total;
    /**
     * 已用库存
     */
    private Integer used;
    /**
     * 剩余库存
     */
    private Integer residue;
}
