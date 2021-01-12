package ua.vbodnar.springcourceWithAlys.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.vbodnar.springcourceWithAlys.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    private static final String URL = "jdbc:mysql://localhost:3306/dbwithalys?serverTimezone=UTC";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "root";
//
//    private static Connection connection;

// отримуємо за допомогою jdbcTemplate.query() дані із БД і перетворюємо їх з допомогою PersonMapper в обєкти
// класу який нам потрібний (створюємо для цього клас PersonMapper)
// використав готовий rowMapper (тільки для тих обєктів, поля яких в БД і в класі однакові)
    public List<Person> allPeople() {
        return jdbcTemplate.query("Select * from person", new BeanPropertyRowMapper<>(Person.class));
    }

// показати людину із id яке приходить
//    new Object[]{id} - це може бути масив обєктів або тому, що після нього йде ще один аргумент
// і за допомогою PersonMapper повертаємо такий обєкт, або null якщо не існує
    public Person show(int id) {
        return jdbcTemplate.query("Select * from person where id=?", new Object[]{id}, new PersonMapper())
                .stream().findAny().orElse(null);

    }

// метод який додасть нову людину в базу і перед додаванням встановить їй наступну ID
    public void save(Person person) {
        jdbcTemplate.update("insert into Person values(1, ?, ?, ?)",
                person.getName(), person.getAge(), person.getEmail());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=? WHERE id=?",
                updatedPerson.getName(),updatedPerson.getAge(), updatedPerson.getEmail(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE from Person where id=?", id);
    }
}
