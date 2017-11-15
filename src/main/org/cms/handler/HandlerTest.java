package cms.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerTest implements HandlerInterceptor {

    /**
     * 在DispatcherServlet之前执行
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object obj) throws Exception {
        System.out.println("HandlerInterceptor     全局   在DispatcherServlet之前执行");
        httpServletRequest.setAttribute("handler", "handler");
        return true;
    }

    /**
     * 在controller执行之后的DispatcherServlet之后执行
     */
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object obj, ModelAndView model) throws Exception {
        System.out.println("HandlerInterceptor   全局      在controller执行之后的DispatcherServlet之后执行");
    }

    /**
     * 在页面渲染完成返回给客户端之前执行
     */
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object obj, Exception e) throws Exception {
        System.out.println("HandlerInterceptor    全局     在页面渲染完成返回给客户端之前执行");
    }

}
