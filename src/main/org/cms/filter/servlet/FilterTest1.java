package cms.filter.servlet;

import javax.servlet.*;
import java.io.IOException;

public class FilterTest1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Servlet Filter Init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Servlet Filter Do");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet Filter Destory");
    }
}
