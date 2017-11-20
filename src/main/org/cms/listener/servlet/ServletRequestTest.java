package cms.listener.servlet;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class ServletRequestTest implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent request) {
        // TODO request销毁事件
        System.out.println("Listener ServletRequest Destory");
    }
    @Override
    public void requestInitialized(ServletRequestEvent request) {
        System.out.println("Listener ServletRequest Init");
        // TODO request初始化事件
    }
}
