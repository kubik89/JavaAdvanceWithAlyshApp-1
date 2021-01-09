package ua.vbodnar.springcourceWithAlys.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// @RequestMapping - всі методи контролера будуть відображатися за посиланням починаючи з (в дужках)
@RequestMapping("/calculator")
public class CalculatorController {

// даний метод буде за посиланням -- шлях до контроллера / шлях що тут в дужках
    @GetMapping("/calculator")
    public String getResult(
// @RequestParam - це значення які ми передаємо як параметри для метода
            @RequestParam(value = "a") int a,
            @RequestParam(value = "b") int b,
            @RequestParam(value = "action") String action,
// allResults - це модель, що буде передана потім на відображення
            Model allResults) {
        double result;
        switch (action) {
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a / b;
                break;
            default:
                result = 0;
                break;
        }
// addAttribute - це метод класу Model, тут передаємо результат нашої змінної у файл "result"
        allResults.addAttribute("result", result);
// вказуємо, що наш файл result за посиланням в каталозі
        return "/calculator/result";

        }
//        -----------------------
//        Зробив окремими методами й файлами сторінками. Вверху одним методом через case і одну сторінку
//        @GetMapping("/addition")
//        public String addition (
//        @RequestParam(value = "a", required = true) int a,
//        @RequestParam(value = "b", required = true) int b,
//        Model addition){
//            int summ = a + b;
//            addition.addAttribute("summ", "Addition result = " + summ);
//
//            return "calculator/addition";
//        }
//
//        @GetMapping("/subtraction")
//        public String subtraction (
//        @RequestParam(value = "a", required = true) int a,
//        @RequestParam(value = "b", required = true) int b,
//        Model subtraction){
//            int subtr = a - b;
//            subtraction.addAttribute("subtr", "Subtraction result = " + subtr);
//
//            return "calculator/subtraction";
//        }
//
//        @GetMapping("/multiplication")
//        public String multiplication (
//        @RequestParam(value = "a", required = true) int a,
//        @RequestParam(value = "b", required = true) int b,
//        Model multiplication) {
//            int multipl = a * b;
//            multiplication.addAttribute("miltipl", "Multiplication result = " + multipl);
//
//            return "calculator/multiplication";
//        }
//        -----------------------
    }
