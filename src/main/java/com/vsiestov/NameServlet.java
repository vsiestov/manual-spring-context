package com.vsiestov;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@WebServlet("/name")
public class NameServlet extends HttpServlet {

    private static final String SRPING_APP_CONTEXT = "SRPING_APP_CONTEXT";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        config.getServletContext().setAttribute(SRPING_APP_CONTEXT, context);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        AnnotationConfigApplicationContext context =
            (AnnotationConfigApplicationContext) req.getServletContext().getAttribute(SRPING_APP_CONTEXT);

        NameProvider nameProvider = context.getBean(NameProvider.class);

        System.out.println(nameProvider);

        resp.getWriter().write(nameProvider.getName());
    }
}
