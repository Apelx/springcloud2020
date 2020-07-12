package cn.apelx.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * 账户DAO
 *
 * @author lx
 * @since 2020/7/11 0:08
 */
@Mapper
public interface AccountDAO {

    /**
     * 扣除账户余额
     *
     * @param userId 用户ID
     * @param money  扣除额度
     */
    void decreaseAccount(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
