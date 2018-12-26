package org.edu.mirea.initializer;

import org.edu.mirea.configuration.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by mr.balalykin on 24.12.2018.
 */

public class AccidentControllerWebApplicationInitializer implements WebApplicationInitializer {
    private final static String DISPATCHER = "dispatcher";

    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        context.register(WebConfig.class);
        servletContext.addListener((new ContextLoaderListener(context)));

        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER, new DispatcherServlet(context));
        servlet.addMapping("/"); // то что полсе localhost:8080, то же должно быть и в конфиге томката
        servlet.setLoadOnStartup(1); // порядок инициализации, нужно если несколько сервлетов
    }
}
