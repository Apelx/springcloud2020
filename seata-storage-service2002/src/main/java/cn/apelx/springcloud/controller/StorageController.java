package cn.apelx.springcloud.controller;

import cn.apelx.springcloud.domain.CommonResult;
import cn.apelx.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 库存Controller
 *
 * @author lx
 * @since 2020/7/10 22:48
 */
@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class StorageController {


    private StorageService storageService;

    @PostMapping(value = "/storage/decrease")
    public CommonResult decreaseStorage(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        storageService.decreaseStorage(productId, count);
        return new CommonResult(200, "扣减库存成功");
    }

    @Autowired
    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }
}
