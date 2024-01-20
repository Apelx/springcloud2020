package cn.apelx.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * git webHook 访问报错
 * 只过滤/actuator/bus-refresh请求
 *
 * @author apelx
 * @since 2020-11-06
 */
@Component
@Slf4j
public class UrlFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();
        // 只过滤 /actuator/bus-refresh请求
        String FILTER_PATH = "/actuator/bus-refresh";
        if (!url.endsWith(FILTER_PATH)) {
            filterChain.doFilter(request, response);
        }
        log.info("url filter into >>>>>>>> ");
        CustomerRequestWrapper requestWrapper = new CustomerRequestWrapper(request);
        filterChain.doFilter(requestWrapper, response);
    }

    private class CustomerRequestWrapper extends HttpServletRequestWrapper {

        public CustomerRequestWrapper(HttpServletRequest request) {
            super(request);
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            byte[] bytes = new byte[0];
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            return new ServletInputStream() {
                @Override
                public boolean isFinished() {
                    return byteArrayInputStream.read() == -1;
                }

                @Override
                public boolean isReady() {
                    return false;
                }

                @Override
                public void setReadListener(ReadListener readListener) {

                }

                @Override
                public int read() throws IOException {
                    return byteArrayInputStream.read();
                }
            };
        }
    }
}
