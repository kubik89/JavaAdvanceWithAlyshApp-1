package ua.vbodnar.springcourceWithAlys.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

// при запуску посилання запуститься цей метод, який поверне файл "/views/hello-world.html"
// (тип файлу описаний нами в SpringConfig)
    @GetMapping("/sayHello")
    public String sayHello() {
        return "hello-world";
    }
}
