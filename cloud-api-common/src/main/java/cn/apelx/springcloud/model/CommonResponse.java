package cn.apelx.springcloud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 全局响应体
 *
 * @author lx
 * @since 2020/4/30 9:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResponse(Integer code, String message) {
        this(code, message, null);
    }
}
