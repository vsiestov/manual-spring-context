package com.vsiestov;


import com.vsiestov.config.Config;
import com.vsiestov.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import java.util.Set;

public class Initialization implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        servletContext.setAttribute(Config.SPRING_APP_CONTEXT, context);
    }
}
