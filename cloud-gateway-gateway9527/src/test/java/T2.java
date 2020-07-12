import java.time.ZonedDateTime;

/**
 * 获取当前时间
 *
 * @author lx
 * @since 2020/6/28 15:40
 */
public class T2 {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        // 2020-06-28T15:40:56.571+08:00[Asia/Shanghai]
    }
}
