package cn.apelx.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 库存 DAO
 *
 * @author lx
 * @since 2020/7/10 22:29
 */
@Mapper
public interface StorageDAO {

    /**
     * 扣减产品库存
     *
     * @param productId 产品ID
     * @param count     扣减数量
     */
    void decreaseStorage(@Param("productId") Long productId, @Param("count") Integer count);
}
