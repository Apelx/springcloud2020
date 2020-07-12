package cn.apelx.springcloud.service;

/**
 * 库存接口
 *
 * @author lx
 * @since 2020/7/10 22:43
 */
public interface StorageService {

    /**
     * 减扣产品库存
     *
     * @param productId 产品ID
     * @param count     减扣数量
     */
    void decreaseStorage(Long productId, Integer count);
}
