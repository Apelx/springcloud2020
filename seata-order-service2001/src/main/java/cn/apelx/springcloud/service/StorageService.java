package cn.apelx.springcloud.service;

import cn.apelx.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 库存接口
 *
 * @author lx
 * @since 2020/7/10 18:53
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    /**
     * 减少库存
     *
     * @param productId 产品ID
     * @param count     减少量
     * @return
     */
    @PostMapping(value = "/storage/decrease")
    CommonResult decreaseStorage(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
