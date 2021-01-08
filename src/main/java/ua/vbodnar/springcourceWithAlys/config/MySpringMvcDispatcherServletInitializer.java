package ua.vbodnar.springcourceWithAlys.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    // переписали рідний метод від абстрактного, вказавши де міститься конфігурація
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class};
    }

    // вказуємо, що всі запити по / будуть направлені на dispatcherServlet
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
