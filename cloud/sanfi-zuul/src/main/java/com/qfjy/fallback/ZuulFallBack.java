package com.qfjy.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName ZuulFallBack
 * @Description TODO
 * @Author guoweixin
 * @Date 2022/6/6
 * @Version 1.0
 */
@Component
public class ZuulFallBack implements FallbackProvider {
    @Override
    public String getRoute() {
        //可以配置指定的路由，值为serviceId  如 dudu-video
        //  *代表全部出现问题的服务，都走Zull降级方法
        return "sanfi-meeting";
    }
    /**
     * @param route  路由服务的 名称
     * @param cause  异常的信息（常用于日志记录）
     * @return
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        System.out.println("记录日志：路由的服务是："+route+"\t"+cause.getMessage());
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                //具体的状态码 500
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                //返回原始状态码
                return HttpStatus.INTERNAL_SERVER_ERROR.value();
            }

            @Override
            public String getStatusText() throws IOException {
                //指定错误状态文本信息
                return HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
            }

            @Override
            public void close() {
            }

            @Override
            public InputStream getBody() throws IOException {
                String msg=route+"服务器开小差了..";
                return new ByteArrayInputStream(msg.getBytes());
            }
            @Override
            public HttpHeaders getHeaders() {
                //响应头信息 JSON格式
                HttpHeaders httpHeaders=new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                return httpHeaders;
            }
        };
    }
}
