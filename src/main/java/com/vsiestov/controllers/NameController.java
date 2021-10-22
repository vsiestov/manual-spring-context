package com.vsiestov.controllers;

import com.vsiestov.services.NameProvider;
import com.vsiestov.config.Config;
import org.springframework.context.ApplicationContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class NameController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ApplicationContext context = (ApplicationContext) req.getServletContext().getAttribute(Config.SPRING_APP_CONTEXT);
        NameProvider provider = context.getBean(NameProvider.class);

        resp.getWriter().println(provider.getName());
    }
}
