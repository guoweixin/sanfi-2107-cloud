package com.qfjy.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.qfjy.util.result.ResultCode;
import com.qfjy.util.result.ResultJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName AuthFilter
 * @Description TODO
 * @Author guoweixin
 * @Date 2022/6/6
 * @Version 1.0
 */
@Component
@Slf4j
public class AuthFilter extends ZuulFilter {
    /*
  - pre过滤器。在请求被路由之前调用。Zuul请求微服务之前。比如请求身份验证，选择微服务实例，记录调试信息等。
  - route过滤器。负责转发请求到微服务。原始请求在此构建，并使用Apache HttpClient或Netflix Ribbon发送原始请求。
  -post过滤器。在route和error过滤器之后被调用。可以在响应添加标准HTTP Header、收集统计信息和指标，以及将响应发送给客户端等。
  -error过滤器。在处理请求发生错误时被调用。
   */
    //指定过滤器类型
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
    //指定过滤器优先级 过滤器顺序，数字越小越先执行
    @Override
    public int filterOrder() {
        return 0;
    }
    //是否使用该过滤器。
    @Override
    public boolean shouldFilter() {
        return true;
    }
    //过滤器具体执行的操作
    @Override
    public Object run() throws ZuulException {
        System.out.println("是否执行这个AuthFilter业务逻辑---》");


        RequestContext ctx= RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();

        log.info(String.format("%s  请求的地址是：  %s",request.getMethod(),request.getRequestURL()));

        Object  accessToken=request.getParameter("token");
        if(accessToken==null){
            log.warn(" accessToken is empyt 用户没有认证信息。登录失败");

            //   ctx.setSendZuulResponse(false);//响应失败
            ctx.getResponse().setCharacterEncoding("GBK");

            //设定响应体代码给前端
            Object obj= new ResultJson("当前未登录或token失效，请重新登录", ResultCode.NOT_LOGIN);
            ObjectMapper objectMapper=new ObjectMapper();
            try {
                String responseBodyStr= objectMapper.writeValueAsString(obj);
                ctx.setResponseBody(responseBodyStr);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return null;
        }
        log.info("token  success---");




        return null;
    }
}
