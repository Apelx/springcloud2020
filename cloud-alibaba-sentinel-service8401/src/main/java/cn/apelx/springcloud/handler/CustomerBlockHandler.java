package cn.apelx.springcloud.handler;

import cn.apelx.springcloud.model.CommonResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 自定 阻塞处理Handler
 *
 * @author lx
 * @since 2020/7/9 22:46
 */
public class CustomerBlockHandler {

    public static CommonResponse handlerException(BlockException blockException) {
        return new CommonResponse(44444, "按客户自定义, Global handlerException ----- 1");
    }

    public static CommonResponse handlerException2(BlockException blockException) {
        return new CommonResponse(44444, "按客户自定义, Global handlerException ----- 2");
    }
}
