package cms.listener.springmvc;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

public class ContextLoad extends ContextLoaderListener {
    @Override
    public void closeWebApplicationContext(ServletContext servletContext) {
        // TODO Auto-generated method stub
        System.out.println("Listener Spring容器加载监听器 Spring ServletContext Close");
        super.closeWebApplicationContext(servletContext);
    }


    @Override
    public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
        // TODO 初始化 ServletContext 上下文 这个方法在contextInitialized 方法之前调用
        System.out.println("Listener Spring容器加载监听器 Spring ServletContext Init Web");
        return super.initWebApplicationContext(servletContext);
    }


    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("Listener  Spring容器加载监听器 Spring ServletContext Init");
        // TODO 上下文初始化成功
        super.contextInitialized(event);
    }
}
