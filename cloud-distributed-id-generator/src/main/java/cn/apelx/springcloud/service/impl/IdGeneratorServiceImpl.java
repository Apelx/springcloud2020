package cn.apelx.springcloud.service.impl;

import cn.apelx.springcloud.service.IdGeneratorService;
import cn.apelx.springcloud.util.IdGeneratorSnowFlakeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ID生成器接口实现类
 *
 * @author lx
 * @since 2020/7/11 16:22
 */
@Service
@Slf4j
public class IdGeneratorServiceImpl implements IdGeneratorService {

    private IdGeneratorSnowFlakeUtil idGeneratorSnowFlakeUtil;


    @Autowired
    public void setIdGeneratorSnowFlakeUtil(IdGeneratorSnowFlakeUtil idGeneratorSnowFlakeUtil) {
        this.idGeneratorSnowFlakeUtil = idGeneratorSnowFlakeUtil;
    }

    /**
     * 生成分布式唯一ID
     *
     * @param workerId
     * @param dataCenterId
     * @return
     */
    @Override
    public long generatorDistributeId(Long workerId, Long dataCenterId) {
        if (workerId != null && dataCenterId != null) {
            return idGeneratorSnowFlakeUtil.snowFlakeId(workerId, dataCenterId);
        }
        return idGeneratorSnowFlakeUtil.snowFlakeId();
    }
}
