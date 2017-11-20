package cms.servlet;

import cms.exception.ExceptionBase;
import cms.exception.ExceptionTest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String user = request.getParameter("username");
        request.getSession().setAttribute("user", user);
//        request.getRequestDispatcher("/index.jsp").forward(request, response);
        response.sendRedirect("/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            ExceptionTest.Test(1,"infos");
        } catch (ExceptionBase exceptionBase) {
            exceptionBase.printStackTrace();
        }

        response.getWriter().write("TestServlet Get");
    }
}
