package cms.listener.servlet;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionTest implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent session) {

//        ServletContext context = session.getSession().getServletContext();
//        Integer count = (Integer) context.getAttribute("count");
//        if (count == null) {
//            count = new Integer(1);
//        } else {
//            int co = count.intValue();
//            count = new Integer(co + 1);
//        }
//        System.out.println("当前用户人数：" + count);
//        context.setAttribute("count", count);//保存人数

        System.out.println("Listener HttpSessionListener Init");
        // TODO session创建
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent session) {

//        ServletContext context = session.getSession().getServletContext();
//        Integer count = (Integer) context.getAttribute("count");
//        int co = count.intValue();
//        count = new Integer(co - 1);
//        context.setAttribute("count", count);
//        System.out.println("当前用户人数：" + count);
//        session.getSession().invalidate();//销毁session  注销时使用

        System.out.println("Listener HttpSessionListener Destory");
        // TODO session销毁
    }
}
