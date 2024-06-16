package controller;

import service.DemoService;
import service.impl.DemoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ZhuYi
 * @create 2024/6/16 18:09
 */
@WebServlet(urlPatterns = "/demo")
public class DemoServlet extends HttpServlet {
    private DemoService demoService = new DemoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> all = demoService.findAll();
        resp.getWriter().println(all);
    }
}
