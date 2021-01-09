package ua.vbodnar.springcourceWithAlys.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam (value = "lName", required = false) String lName,
            Model model) {

        model.addAttribute("message", "Hello " + name + " " + lName);
        //        System.out.println("Hello " + name + " " + lName);

        return "first/hello";
    }

//    @GetMapping("/hello")
//    public String helloPage(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String lName = request.getParameter("lName");
//        System.out.println("Hello " + name + " " + lName);
//        return "first/hello";
//    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}
