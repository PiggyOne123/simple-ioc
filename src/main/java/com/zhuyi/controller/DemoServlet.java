package com.zhuyi.controller;

import com.zhuyi.factoty.BeanFactory;
import com.zhuyi.service.DemoService;
import com.zhuyi.service.impl.DemoServiceImpl;

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
    // 通过BeanFactory获取名为"demoService"的Bean实例
    DemoService demoService = (DemoService) BeanFactory.getBean("demoService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> all = demoService.findAll();
        resp.getWriter().println(all);
    }
}
