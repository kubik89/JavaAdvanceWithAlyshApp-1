package ua.vbodnar.springcourceWithAlys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.vbodnar.springcourceWithAlys.dao.PersonDAO;
import ua.vbodnar.springcourceWithAlys.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

// якщо GetMapping() без аргументів, значить даний метод запуститься за посиланням RequestMapping що вгорі
    @GetMapping()
    public String getAllPeople(Model model) {
// отримуємо всіх людей із DAO і передаємо на відображення в представлення
// як ключ people передаю дані з методу allPeople() у html файл people/index
        model.addAttribute("people", personDAO.allPeople());
        return "people/index";
    }

// з допомогою @PathVariable ми витягнемо із url-и id і отримаємо до нього доступ в методі
// коли програма запуститься, то за допомогою  @GetMapping можна передати id, яке прокинеться
// в метод show для

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
// отримуємо одну людину по id із DAO і передаємо на відображення в представлення
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
// метод який створить форму...Модель передаємо завжди, бо потім відображаємо через thymeleaf по моделі
// якщо з @ModelAttribute - то вона сама створить обєкт Person і додасть атрибут
    public String newPerson(@ModelAttribute("person") Person person) {
//    public String newPerson(Model model) {
//        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping
    // з допомогою ModelAttribute в обєкт person ми отримаємо людину, яка прийде із форми вище по ключу "person"
    public String create(@ModelAttribute("person") Person person) {
        personDAO.save(person);
        return "redirect:/people";
    }
 }
