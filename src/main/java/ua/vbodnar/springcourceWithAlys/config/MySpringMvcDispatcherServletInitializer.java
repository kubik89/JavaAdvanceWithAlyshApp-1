package ua.vbodnar.springcourceWithAlys.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

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

// onStartup запускається при старті spring програми і виконує наш метод registerHiddenFieldFilter в якому
//   спрацюовує фільт спрінга HiddenHttpMethodFilter, який
//     вичитує під капотом скрите поле "_method",
//     дивиться який Http метод там знаходиться
//     і буде перенаправляти вхідні Http запити на потрібні методи контроллера
    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);
        registerHiddenFieldFilter(aServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext aServletContext) {
        aServletContext.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null, true, "/*");
    }
}
