package cms.listener.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextTest implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // TODO serletContext销毁
        System.out.println("Listener ServletContext Destory");
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("Listener ServletContext Init");
        // TODO serletContext创建
    }
}
