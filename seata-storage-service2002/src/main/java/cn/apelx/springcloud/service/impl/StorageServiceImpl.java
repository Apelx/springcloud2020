package cn.apelx.springcloud.service.impl;

import cn.apelx.springcloud.dao.StorageDAO;
import cn.apelx.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 库存接口实现类
 *
 * @author lx
 * @since 2020/7/10 22:43
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    private StorageDAO storageDAO;

    /**
     * 减扣产品库存
     *
     * @param productId 产品ID
     * @param count     减扣数量
     */
    @Override
    public void decreaseStorage(Long productId, Integer count) {
        log.info("-----> storageService 减扣库存开始");
        storageDAO.decreaseStorage(productId, count);
        log.info("-----> storageService 减扣库存结束");
    }

    @Autowired
    public void setStorageDAO(StorageDAO storageDAO) {
        this.storageDAO = storageDAO;
    }
}
