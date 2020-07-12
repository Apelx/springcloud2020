package cn.apelx.springcloud.service;

/**
 * ID生成器接口
 *
 * @author lx
 * @since 2020/7/11 16:22
 */
public interface IdGeneratorService {

    /**
     * 生成分布式唯一ID
     *
     * @param workerId
     * @param dataCenterId
     * @return
     */
    long generatorDistributeId(Long workerId, Long dataCenterId);
}
