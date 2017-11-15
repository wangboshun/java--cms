package cms.filter;

import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterTest extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        httpServletRequest.setAttribute("filter", "filter");

        System.out.println("OncePerRequestFilter           DispatcherServlet 视图渲染之前执行");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        System.out.println("OncePerRequestFilter           DispatcherServlet 视图渲染之后执行");
    }
}
