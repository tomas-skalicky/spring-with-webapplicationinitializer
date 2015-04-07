package cz.skalicky.hello.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(final ServletContext servletContext) {

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);

        servletContext.addListener(new Log4jConfigListener());

        servletContext.addListener(new ContextLoaderListener(rootContext));

        addHelloDispatcher(servletContext);
    }

    private void addHelloDispatcher(final ServletContext servletContext) {

        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(MvcConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("helloDispatcher",
                dispatcherServlet);
        dispatcher.addMapping("/");
    }

}
